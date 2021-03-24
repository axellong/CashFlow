package entity;

public class Clasificacion {
    private int idClasificacion;
    private String nombreClasificacion;

    public Clasificacion() {
    }

    public Clasificacion(int idClasifiacion, String nombreClasificaion) {
        this.idClasificacion = idClasifiacion;
        this.nombreClasificacion = nombreClasificaion;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNombreClasificacion() {
        return nombreClasificacion;
    }

    public void setNombreClasificacion(String nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
    }
}
