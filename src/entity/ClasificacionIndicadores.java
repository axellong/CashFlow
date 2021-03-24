package entity;

public class ClasificacionIndicadores {

    private int idClasificadoresIndicadores;
    private String nombreClasificacion;

    public ClasificacionIndicadores() {
    }

    public ClasificacionIndicadores(int idClasificadoresIndicadores, String nombreClasificacion) {
        this.idClasificadoresIndicadores = idClasificadoresIndicadores;
        this.nombreClasificacion = nombreClasificacion;
    }

    public int getIdClasificadoresIndicadores() {
        return idClasificadoresIndicadores;
    }

    public void setIdClasificadoresIndicadores(int idClasificadoresIndicadores) {
        this.idClasificadoresIndicadores = idClasificadoresIndicadores;
    }

    public String getNombreClasificacion() {
        return nombreClasificacion;
    }

    public void setNombreClasificacion(String nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
    }
}
