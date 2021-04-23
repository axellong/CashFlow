package entity;

public class RegistroBanco {
    private int idRegistroBanco;
    private int numeroCuenta;
    private double monto;
    private String descripcion;
    private int semana;
    private String mes;
    private int anio;

    public RegistroBanco() {

    }

    public RegistroBanco(int numeroCuenta, double monto, String descripcion, int semana, String mes, int anio) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.descripcion = descripcion;
        this.semana = semana;
        this.mes = mes;
        this.anio = anio;
    }

    public int getIdRegistroBanco() {
        return idRegistroBanco;
    }

    public void setIdRegistroBanco(int idRegistroBanco) {
        this.idRegistroBanco = idRegistroBanco;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "RegistroBanco{" +
                "numeroCuenta=" + numeroCuenta +
                ", monto=" + monto +
                ", semana=" + semana +
                ", mes='" + mes + '\'' +
                ", anio=" + anio +
                '}';
    }
}
