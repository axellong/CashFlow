package entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class RegistroEfectivo {

    private int idRegistroEfectivo;
    private String tipoMovimiento;
    private int idCategoria;
    private String concepto;
    private double monto;
    private Date fecha;
    private Time hora;
    private SubCategoria idSubcategoria;
    private int idClasificacion;
    private int semana;
    private String mes;
    private int anio;

    private int[] semanas = new int[5];

    //lista para hibernete
    private List<ReportesEfectivo> listaReportesEfectivo;

    public RegistroEfectivo() {
    }

    public int[] getSemanas() {
        return semanas;
    }

    public void setSemanas(int[] semanas) {
        this.semanas = semanas;
    }

    public List<ReportesEfectivo> getListaReportesEfectivo() {
        return listaReportesEfectivo;
    }

    public void setListaReportesEfectivo(List<ReportesEfectivo> listaReportesEfectivo) {
        this.listaReportesEfectivo = listaReportesEfectivo;
    }

    public RegistroEfectivo(String tipoMovimiento, int idCategoria, String concepto, double monto, Date fecha, Time hora, SubCategoria idSubcategoria, int idClasificacion) {
        this.tipoMovimiento = tipoMovimiento;
        this.idCategoria = idCategoria;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.idSubcategoria = idSubcategoria;
        this.idClasificacion = idClasificacion;
    }

    public RegistroEfectivo(String tipoMovimiento, int idCategoria, String concepto, double monto, Date fecha, Time hora, SubCategoria idSubcategoria, int idClasificacion, String mes, int semana, int anio) {
        this.tipoMovimiento = tipoMovimiento;
        this.idCategoria = idCategoria;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.idSubcategoria = idSubcategoria;
        this.idClasificacion = idClasificacion;
        this.mes = mes;
        this.semana = semana;
        this.anio = anio;
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

    public SubCategoria getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(SubCategoria idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "RegistroEfectivo{" +
                "idRegistroEfectivo=" + idRegistroEfectivo +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", idCategoria=" + idCategoria +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", idSubcategoria=" + idSubcategoria +
                ", idClasificacion=" + idClasificacion +
                '}';
    }
}
