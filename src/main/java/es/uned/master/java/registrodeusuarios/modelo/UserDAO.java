package es.uned.master.java.registrodeusuarios.modelo;
/**
 * Esta clase define el Data Access Objet (DAO)
 * @author: Irina Medina Sierra
 * @version: 15/06/2022
 * @description: Clase que permite validar y registrar los datos introducidos en los jsp en la base de datos.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static Connection con;
    public static Conexion cn = new Conexion();
    public static PreparedStatement ps;
    public static ResultSet rs;


    /**
     * Este método se encarga de validar que el usuario y la contraseña son correcta
     * En caso de existir algun error, devuelve 0 al controlador y vuelve a cargar la pagina de inicio.
     * Para realizar la conexión con la Base de Datos, llama a la clase Conexion
     * Para capturar los datos llama la clase Usuario
     * Realiza la Query para comprobar que los datos son correctos.
     *
     * @return 1 si almacena correctamente y
     * @return 0 si existe un error
     */
    public static int validar(Usuario user) {
        //variable del metodo que controla si la validacion es correcta(1) o incorrecta(0)
        int r = 0;
        //variable de tipo String(sql) que almacena el query para luego realizar la consulta preparada
        String sql = "SELECT  * FROM BancaOnline.usuarios WHERE usuario=? AND password=?;";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            //Bucle while que hace la comprobación de que haya alguna coincidencia entre lo insertado por el usuario
            // y la base de datos. si no hay nada, no entra al bucle.
            while (rs.next()) {
                r = r + 1;
                //se utiliza un contador, para saber si encuentra el usuario, el valor de r cambia, y muestra el CRUD
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setNombre(rs.getString("nombres"));
            }
            //se retorna al controlador el resultado 1: el usuario y contraseña son correctas y 0: son incorrectas.
            rs.close();
            return r;
        } catch (Exception e) {
            System.out.println("no llega a realizar la conexion");
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

    }

    /**
     * Este método se encarga de validar que el usuario no exista en la base de datos
     * para evitar duplicados de usuarios en la bbdd
     *
     * @param user
     * @return true no exite
     * @return false si existe
     */
    public static boolean validarUsuario(String user) {
        System.out.println(user);
        String sql_comparador = "select usuario from BancaOnline.usuarios where usuario=?";
        boolean resultado = true;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql_comparador);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("El usuario existe");
                resultado = false;
            }
            rs.close();
        } catch (Exception e) {
            resultado = true;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
        System.out.println("usuario es:" + resultado);
        return resultado;
    }

    /**
     * Este método se encarga de validar que la contraseña cumpla con los requisitos establecidos por la aplicacion:
     * 2 Mayusculas, 2 minusculas, 2 numericos, 2 caracteres especiales
     *
     * @param pass
     * @return true si es correcto
     * @return false porque no cumple con los requisitos
     */
    public static boolean validarPass(String pass) {
        //Especifica el maximo de caracteres del password
        int max = 8;
        //Especifica el minimo de mayusculas del password
        int minUppercase = 2;
        //Especifica el minimo de minusculas del password
        int minLowercase = 2;
        // Especifica el numero de digitos del password
        int numDigits = 2;
        // Especifica el numero de caracteres especiales
        int special = 2;
        // Contador de letras en mayusculas
        int uppercaseCounter = 0;
        // contador de letras en minusculas
        int lowercaseCounter = 0;
        // contador de digitos
        int digitCounter = 0;
        // contador de caracteres especiales
        int specialCounter = 0;
        //En el siguiente bucle, contamos cuantos caracteres tiene en mayusculas, minusculas, digitos y caracteres especiales
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c))
                uppercaseCounter++;
            else if (Character.isLowerCase(c))
                lowercaseCounter++;
            else if (Character.isDigit(c))
                digitCounter++;
            if (c >= 33 && c <= 46 || c == 64) {
                specialCounter++;
            }
        }
        return pass.length() >= max && uppercaseCounter >= minUppercase
                && lowercaseCounter >= minLowercase && digitCounter >= numDigits && specialCounter >= special;
    }

    /**
     * Este método se encarga de dar de alta en la Base de Datos los datos de los nuevos usuarios
     * Para realizar la conexión con la Base de Datos, llama a la clase Conexion
     * Para capturar los datos llama la clase Usuario
     * También valida que los datos no esten vacios
     *
     * @return 1 si almacena correctamente y
     * @return 0 si existe un error
     */
    public static int registrar(Usuario user) {
        int numeroRegistro = 0;
        //validamos del lado del servidor, que ninguno de los datos solicitados esten en blanco
        if (!user.getNombre().isEmpty() || !user.getEmail().isEmpty() || !user.getUsuario().isEmpty() || !user.getPassword().isEmpty()) {
            //en el siguiente if, llamamos al metodo que valida si el usuario ya existe,
            if (!validarUsuario(user.getUsuario())) {
                numeroRegistro = 3;
                //en el siguiente if llamamos el metodo que valida que el password cumple con los requisitos
            }
            if (!validarPass(user.getPassword())) {
                numeroRegistro = 2;
            }
            if (numeroRegistro == 0) {
                System.out.println("aqui entra");
                int ejecuta;
                String sql = "INSERT INTO BancaOnline.usuarios (nombres,email,usuario,password) VALUES (?,?,?,?);";
                try {
                    System.out.println("Estamos en el try");
                    con = cn.Conectar();
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user.getNombre());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, user.getUsuario());
                    ps.setString(4, user.getPassword());
                    ejecuta = ps.executeUpdate();
                    System.out.println(ejecuta);
                    numeroRegistro = 1;
                    rs.close();
                } catch (SQLException err) {
                    System.out.println(err);
                    return numeroRegistro;
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return numeroRegistro;
    }

    public static List<Usuario> listar() {
        List<Usuario> list = new ArrayList<Usuario>();
        String sql = "SELECT  * FROM BancaOnline.usuarios order by nombres";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //Bucle while para recorrer los registros de los usuarios en la bbdd
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("idusuarios"));
                u.setNombre(rs.getString("nombres"));
                u.setEmail(rs.getString("email"));
                u.setUsuario(rs.getString("usuario"));
                list.add(u);

            }
            rs.close();
        }  catch (SQLException e){
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return list;
    }
}



