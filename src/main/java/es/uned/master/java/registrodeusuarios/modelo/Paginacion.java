package es.uned.master.java.registrodeusuarios.modelo;

public class Paginacion {
    int pagina;
    int comienzo;
    int fin;

    public Paginacion() {
        this.pagina = pagina;
        this.comienzo = comienzo;
        this.fin = fin;
    }

    public int getPagina(int i) {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getComienzo() {
        return comienzo;
    }

    public void setComienzo(int comienzo) {
        this.comienzo = comienzo;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
