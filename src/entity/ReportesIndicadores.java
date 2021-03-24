package entity;

public class ReportesIndicadores {
    private int idReporte;
    private String descripcion;
    private int idRegistroIndicadores;
    private int numReporte;

    public ReportesIndicadores(int idReporte, String descripcion, int idRegistroIndicadores, int numReporte) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.idRegistroIndicadores = idRegistroIndicadores;
        this.numReporte = numReporte;
    }

    public ReportesIndicadores() {
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdRegistroIndicadores() {
        return idRegistroIndicadores;
    }

    public void setIdRegistroIndicadores(int idRegistroIndicadores) {
        this.idRegistroIndicadores = idRegistroIndicadores;
    }

    public int getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(int numReporte) {
        this.numReporte = numReporte;
    }
}
