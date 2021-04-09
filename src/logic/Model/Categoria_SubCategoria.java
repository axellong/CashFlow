package logic.Model;

import entity.SubCategoria;

public class Categoria_SubCategoria {

    private String categoria;
    private String subCategoria;

    private SubCategoria entity;

    public Categoria_SubCategoria(SubCategoria entity){
        this.entity = entity;
        subCategoria = entity.getNombreSubCategoria();
        categoria = entity.getId_Categoria().getNombreCategoria();
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

    public SubCategoria getEntity() {
        return entity;
    }

    public void setEntity(SubCategoria entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return categoria + " - " + subCategoria;
    }
}
