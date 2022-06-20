package es.uned.master.java.registrodeusuarios.modelo;

import java.sql.*;

public class Conexion {
    public Conexion(){}

    public Connection Conectar() {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BancaOnline?serverTimezone=UTC", "uned", "uned");

        } catch (Exception err) {
            //throw new LibreriaException("Error indefinido."+err);
              throw new LibreriaException("Error en la base de datos.");
        }
            return con;

    }
}