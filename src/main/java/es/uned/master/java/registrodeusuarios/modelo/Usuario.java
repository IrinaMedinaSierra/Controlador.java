package es.uned.master.java.registrodeusuarios.modelo;
/**
 *         * @author: Irina Medina Sierra
 *         * @version: 15/06/2022
 *         * @Description:  Esta clase define  el objeto usuario
 *         */

public class Usuario {
    public int id;
    public String nombre;
    public String usuario;
    public String password;
    public String email;

public Usuario(){

}

    /**
     * * Constructor de los datos del usuario      *
     * @param id
     * @param nombre del usuario
     * @param usuario es el que utiliza para hacer login
     * @param password contraseña utilizada para hacer login
     * @param email  del usuario
     *             */
    public Usuario(int id, String nombre, String usuario, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    /**
     * * Constructor de los datos del usuario      *
     * @param nombre del usuario
     * @param usuario es el que utiliza para hacer login
     * @param password contraseña utilizada para hacer login
     * @param email  del usuario
     *             */
    public Usuario( String nombre, String usuario, String password, String email) {

        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }
    //Cierre del constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodos Getter y Setter del objeto usuario
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
