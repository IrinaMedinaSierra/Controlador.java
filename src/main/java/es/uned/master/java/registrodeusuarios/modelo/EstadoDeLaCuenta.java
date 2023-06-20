package es.uned.master.java.registrodeusuarios.modelo;

public class EstadoDeLaCuenta {

   int id;
   String Estado;

    public EstadoDeLaCuenta() {
    }

    public EstadoDeLaCuenta(int id, String estado) {
        this.id = id;
        Estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
