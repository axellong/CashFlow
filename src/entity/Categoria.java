package entity;

import java.util.List;

public class Categoria {

    private int idCategoria;
    private String nombreCategoria;
    private int idUsuario;
    private Clasificacion clasificacion;

    //esto es para el mapeo de hbn
    private List<SubCategoria> subCategorias;


    public Categoria() {
    }

    public Categoria( String nombreCategoria, int idUsuario) {
        this.nombreCategoria = nombreCategoria;
        this.idUsuario = idUsuario;
        this.subCategorias = subCategorias;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", idUsuario=" + idUsuario +
                ", subCategorias=" + subCategorias +
                '}';
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }
}
