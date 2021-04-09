package logic.Model;

import entity.Categoria;
import entity.RegistroEfectivo;
import entity.SubCategoria;
import java.time.LocalDate;
import java.time.ZoneId;

public class FlujoTable {
    private LocalDate fecha;
    private String descripcion;
    private Categoria categoria;
    private SubCategoria subCategoria;

    private RegistroEfectivo entity;

    public FlujoTable(RegistroEfectivo entity) {
        this.entity = entity;
        this.fecha = entity.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.descripcion = entity.getConcepto();
        this.subCategoria = entity.getIdSubcategoria();
        this.categoria = entity.getIdSubcategoria().getId_Categoria();
        this.entity = entity;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public RegistroEfectivo getEntity() {
        return entity;
    }

    public void setEntity(RegistroEfectivo entity) {
        this.entity = entity;
    }
}
