package es.uned.master.java.registrodeusuarios.modelo;

public class Departamento {
    int id;
    String departamento;
    public Departamento(){}
    public Departamento(int id, String departamento) {
        this.id = id;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
