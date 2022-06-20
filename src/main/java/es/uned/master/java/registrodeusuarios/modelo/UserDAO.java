package es.uned.master.java.registrodeusuarios.modelo;

import java.sql.*;

public class UserDAO  {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public int validar(Usuario user) {
        int r = 0;
        String sql = "SELECT  * FROM BancaOnline.usuarios WHERE usuario=? AND password=?;";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                //se utiliza un contador, para saber si encuentra el usuario, el valor de r cambia, y muestra el CRUD
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));

            }
            return r;
        } catch (Exception e) {
            System.out.println("no llega a realizar la conexion");
            e.printStackTrace();
            return 0;
        }

    }

    public int registrar(Usuario user) {
        int numeroRegistro = 0;
        if (!user.getNombre().isEmpty() || !user.getEmail().isEmpty() || !user.getUsuario().isEmpty() || !user.getPassword().isEmpty()) {
            String sql = "INSERT INTO BancaOnline.usuarios (nombres,email,usuario,password) VALUES (?,?,?,?);";
            try {
                con = cn.Conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getUsuario());
                ps.setString(4, user.getPassword());
                ps.executeUpdate();
                numeroRegistro=1;


            } catch (Exception e) {
                return numeroRegistro;
            }
        }return numeroRegistro;
    }
}
