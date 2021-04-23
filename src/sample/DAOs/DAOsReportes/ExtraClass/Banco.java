package sample.DAOs.DAOsReportes.ExtraClass;

public class Banco {
    private int numeroCuenta;
    private double monto;
    private int semana;
    private String mes;
    private int anio;

    public Banco(int numeroCuenta, double monto, int semana, String mes, int anio) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.semana = semana;
        this.mes = mes;
        this.anio = anio;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
        return "Banco{" +
                "numeroCuenta=" + numeroCuenta +
                ", monto=" + monto +
                ", semana=" + semana +
                ", mes='" + mes + '\'' +
                ", anio=" + anio +
                '}';
    }
}
