package logic.Model;

import entity.SubCategoria;

public class CategoryTable {

    private String clasificacion;
    private String categoria;
    private String subCategoria;
    private SubCategoria subCategoriaEntity;

    public CategoryTable(SubCategoria subCategoriaEntity) {
        this.subCategoriaEntity = subCategoriaEntity;
        clasificacion = subCategoriaEntity.getId_Categoria().getClasificacion().getNombreClasificacion();
        categoria = subCategoriaEntity.getId_Categoria().getNombreCategoria();
        subCategoria = subCategoriaEntity.getNombreSubCategoria();
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public SubCategoria getSubCategoriaEntity() {
        return subCategoriaEntity;
    }

    public void setSubCategoriaEntity(SubCategoria subCategoriaEntity) {
        this.subCategoriaEntity = subCategoriaEntity;
    }
}
