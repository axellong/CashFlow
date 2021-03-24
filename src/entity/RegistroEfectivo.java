package entity;

import java.sql.Time;
import java.util.Date;

public class RegistroEfectivo {

    private int idRegistroEfectivo;
    private String tipoMovimiento;
    private int idCategoria;
    private String concepto;
    private double monto;
    private Date fecha;
    private Time hora;
    private int idSubcategoria;
    private int idClasificacion;

    public RegistroEfectivo() {
    }

    public RegistroEfectivo(int idRegistroEfectivo, String tipoMovimiento, int idCategoria, String concepto, double monto, Date fecha, Time hora, int idSubcategoria, int idClasificacion) {
        this.idRegistroEfectivo = idRegistroEfectivo;
        this.tipoMovimiento = tipoMovimiento;
        this.idCategoria = idCategoria;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.idSubcategoria = idSubcategoria;
        this.idClasificacion = idClasificacion;
    }


    public int getIdRegistroEfectivo() {
        return idRegistroEfectivo;
    }

    public void setIdRegistroEfectivo(int idRegistroEfectivo) {
        this.idRegistroEfectivo = idRegistroEfectivo;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
}
