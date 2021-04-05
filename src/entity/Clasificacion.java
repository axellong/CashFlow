package entity;

public class Clasificacion {
    private int idClasificacion;
    private String nombreClasificacion;

    public Clasificacion() {
    }

    public Clasificacion(String nombreClasificion) {
        this.nombreClasificacion = nombreClasificion;
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

    @Override
    public String toString() {
        return "Clasificacion{" +
                "idClasificacion=" + idClasificacion +
                ", nombreClasificacion='" + nombreClasificacion + '\'' +
                '}';
    }
}
