package entity;

public class RegistroIndicadores {

    private int idRegistroIndicadores;
    private int idClasificacion;
    private String concepto;
    private String razonSocial;
    private double monto;
    private String mes;
    private int semana;
    private int ano;
    private String descripcion;

    public RegistroIndicadores(int idRegistroIndicadores, int idClasificacion, String concepto, String razonSocial, double monto, String mes, int semana, int ano, String descripcion) {
        this.idRegistroIndicadores = idRegistroIndicadores;
        this.idClasificacion = idClasificacion;
        this.concepto = concepto;
        this.razonSocial = razonSocial;
        this.monto = monto;
        this.mes = mes;
        this.semana = semana;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public RegistroIndicadores() {
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdRegistroIndicadores() {
        return idRegistroIndicadores;
    }

    public void setIdRegistroIndicadores(int idRegistroIndicadores) {
        this.idRegistroIndicadores = idRegistroIndicadores;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
