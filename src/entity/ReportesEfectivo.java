package entity;

public class ReportesEfectivo {

    private int idReporte;
    private String descripcion;
    private int idRegistroEfectivo;
    private int numReporte;

    public ReportesEfectivo(int idReporte, String descripcion, int idRegistroEfectivo, int numReporte) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.idRegistroEfectivo = idRegistroEfectivo;
        this.numReporte = numReporte;
    }

    public ReportesEfectivo() {
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

    public int getIdRegistroEfectivo() {
        return idRegistroEfectivo;
    }

    public void setIdRegistroEfectivo(int idRegistroEfectivo) {
        this.idRegistroEfectivo = idRegistroEfectivo;
    }

    public int getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(int numReporte) {
        this.numReporte = numReporte;
    }
}
