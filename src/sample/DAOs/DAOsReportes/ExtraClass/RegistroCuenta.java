package sample.DAOs.DAOsReportes.ExtraClass;

public class RegistroCuenta {
    private int cuenta;
    private double monto;
    private String mes;
    private int semana;
    private int anio;


    public RegistroCuenta(){
    }

    public RegistroCuenta(int cuenta, double monto, String mes, int semana, int anio) {
        this.cuenta = cuenta;
        this.mes = mes;
        this.semana = semana;
        this.anio = anio;
        this.monto = monto;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
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
        return "RegistroCuenta{" +
                "cuenta=" + cuenta +
                ", monto=" + monto +
                ", mes='" + mes + '\'' +
                ", semana=" + semana +
                ", anio=" + anio +
                '}';
    }
}
