package entity;

import java.util.List;

public class Clasificacion {
    private int idClasificacion;
    private String nombreClasificacion;
    private List<Categoria> categoriaList;
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

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @Override
    public String toString() {
        return nombreClasificacion;
    }
}
