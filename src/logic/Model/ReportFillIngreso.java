package logic.Model;

public class ReportFillIngreso {
    String numeroCuenta;
    double semana1;
    double semana2;
    double semana3;
    double semana4;
    double semana5;
    double totalSemana;

    public ReportFillIngreso(String cuenta) {
        semana1 = 0.00;
        semana2 = 0.00;
        semana3 = 0.00;
        semana4 = 0.00;
        semana5 = 0.00;
        numeroCuenta=cuenta;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSemana1() {
        return semana1;
    }

    public void setSemana1(double semana1) {
        this.semana1 = semana1;
    }

    public double getSemana2() {
        return semana2;
    }

    public void setSemana2(double semana2) {
        this.semana2 = semana2;
    }

    public double getSemana3() {
        return semana3;
    }

    public void setSemana3(double semana3) {
        this.semana3 = semana3;
    }

    public double getSemana4() {
        return semana4;
    }

    public void setSemana4(double semana4) {
        this.semana4 = semana4;
    }

    public double getSemana5() {
        return semana5;
    }

    public void setSemana5(double semana5) {
        this.semana5 = semana5;
    }

    public double getTotalSemana() {
        return semana1+semana2+semana3+semana4+semana5;
    }

    public void setTotalSemana(double totalSemana) {
        this.totalSemana = totalSemana;
    }
}
