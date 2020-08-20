package Modelo;

public class Sugerencia {
    private int idsugerencia;
    private String fecha;
    private String descripcion;
    private int idpersona;
    private int idrol;
    private int idarea;

    public Sugerencia() {
    }

    public Sugerencia(String fecha, String descripcion, int idpersona, int idrol, int idarea) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idpersona = idpersona;
        this.idrol = idrol;
        this.idarea = idarea;
    }

    public Sugerencia(int idsugerencia, String fecha, String descripcion, int idpersona, int idrol, int idarea) {
        this.idsugerencia = idsugerencia;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idpersona = idpersona;
        this.idrol = idrol;
        this.idarea = idarea;
    }

    public int getIdsugerencia() {
        return idsugerencia;
    }

    public void setIdsugerencia(int idsugerencia) {
        this.idsugerencia = idsugerencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }
    
}

