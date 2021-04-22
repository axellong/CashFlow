package sample.DAOs.DAOsReportes.ExtraClass;

public class Gastos {
    private String nombreClasificacion;
    private double monto;
    private String mes;
    private int semana;
    private int anio;

    public Gastos(String nombreClasificacion, double monto, String mes, int semana, int anio) {
        this.nombreClasificacion = nombreClasificacion;
        this.monto = monto;
        this.mes = mes;
        this.semana = semana;
        this.anio = anio;
    }

    public String getNombreClasificacion() {
        return nombreClasificacion;
    }

    public void setNombreClasificacion(String nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Gastos{" +
                "nombreClasificacion='" + nombreClasificacion + '\'' +
                ", monto=" + monto +
                ", mes='" + mes + '\'' +
                ", semana=" + semana +
                ", anio=" + anio +
                '}';
    }
}
