package logic.Model;

import entity.Categoria;
import entity.RegistroEfectivo;
import entity.SubCategoria;

import java.util.Calendar;
import java.util.Date;

public class FlujoTable {
    private Calendar fecha;
    private String Descripcion;
    private Categoria categoria;
    private SubCategoria subCategoria;

    private RegistroEfectivo entity;

    public FlujoTable(RegistroEfectivo entity) {
        this.entity = entity;
        this.fecha = generateDate(entity.getFecha());
        Descripcion = entity.getConcepto();
        /*this.categoria = ;
        this.subCategoria = subCategoria;*/
        this.entity = entity;
    }

    public Calendar generateDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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
