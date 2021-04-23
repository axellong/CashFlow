package logic.Model.Table;

public class TableGeneral {

    private String cuenta;
    private int semana1;
    private int semana2;
    private int semana3;
    private int semana4;
    private int semana5;
    private int finalT;
    private Object entidad;

    public TableGeneral(String cuenta, int semana1, int semana2, int semana3, int semana4, int semana5, int finalT, Object entidad) {
        this.cuenta = cuenta;
        this.semana1 = semana1;
        this.semana2 = semana2;
        this.semana3 = semana3;
        this.semana4 = semana4;
        this.semana5 = semana5;
        this.finalT = finalT;
        this.entidad = entidad;
    }

    public TableGeneral(){

    }

    public void llenarfinal(){
        finalT = semana1+semana2+semana3+semana4+semana5;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getSemana1() {
        return semana1;
    }

    public void setSemana1(int semana1) {
        this.semana1 = semana1;
    }

    public int getSemana2() {
        return semana2;
    }

    public void setSemana2(int semana2) {
        this.semana2 = semana2;
    }

    public int getSemana3() {
        return semana3;
    }

    public void setSemana3(int semana3) {
        this.semana3 = semana3;
    }

    public int getSemana4() {
        return semana4;
    }

    public void setSemana4(int semana4) {
        this.semana4 = semana4;
    }

    public int getSemana5() {
        return semana5;
    }

    public void setSemana5(int semana5) {
        this.semana5 = semana5;
    }

    public int getFinalT() {
        return finalT;
    }

    public void setFinalT(int finalT) {
        this.finalT = finalT;
    }

    public Object getEntidad() {
        return entidad;
    }

    public void setEntidad(Object entidad) {
        this.entidad = entidad;
    }
}
