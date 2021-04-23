package entity;

public class RegistroIndicadores {

    private int idRegistroIndicadores;
    private String clasificacion;
    private String concepto;
    private String razonSocial;
    private double monto;
    private String mes;
    private int semana;
    private String descripcion;
    private int anio;
    private Cuenta id_Cuenta;
    private int[] semanas = new int[5];


    // lista para hibernete
    // private List<ReportesIndicadores> listaReportes ;
    public RegistroIndicadores(String clasificacion, String concepto, String razonSocial, double monto, String mes, int semana, String descripcion, int anio) {
        this.clasificacion = clasificacion;
        this.concepto = concepto;
        this.razonSocial = razonSocial;
        this.monto = monto;
        this.mes = mes;
        this.semana = semana;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    public RegistroIndicadores(String clasificacion, String concepto, String razonSocial, double monto, String mes, int semana, String descripcion, int anio, Cuenta idCuenta) {
        this.clasificacion = clasificacion;
        this.concepto = concepto;
        this.razonSocial = razonSocial;
        this.monto = monto;
        this.mes = mes;
        this.semana = semana;
        this.descripcion = descripcion;
        this.anio = anio;
        this.id_Cuenta = idCuenta;
    }

    public RegistroIndicadores() {
    }

    public RegistroIndicadores getRegistroIndicadores() {
        return this;
    }

    public Cuenta getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(Cuenta id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    /*
    public List<ReportesIndicadores> getListaReportes() {
        return listaReportes;
    }

    public void setListaReportes(List<ReportesIndicadores> listaReportes) {
        this.listaReportes = listaReportes;
    }
     */

    public int getIdRegistroIndicadores() {
        return idRegistroIndicadores;
    }

    public void setIdRegistroIndicadores(int idRegistroIndicadores) {
        this.idRegistroIndicadores = idRegistroIndicadores;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int[] getSemanas() {
        return semanas;
    }

    public void setSemanas(int[] semanas) {
        this.semanas = semanas;
    }

    private String recorrer(){
        String semanasStr = "";
        for (int i = 0;i<semanas.length ;i++){
            semanasStr = semanasStr + " "+semanas[i] +" ";
        }
        return semanasStr;
    }

    @Override
    public String toString() {
        return "RegistroIndicadores{" +
                ", cuenta=" + id_Cuenta.getCuenta() +
                ", monto=" + monto +
                ", mes='" + mes + '\'' +
                ", semana=" + semana +
                ", semanas=" + recorrer()+
                ", anio=" + anio +
                '}';
    }
}
