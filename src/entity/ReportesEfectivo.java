package entity;

public class ReportesEfectivo {

    private int idReporte;
    private String descripcion;
    private RegistroEfectivo idRegistroEfectivo;
    private int numReporte;


    public ReportesEfectivo(String descripcion, RegistroEfectivo idRegistroEfectivo, int numReporte) {
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

    public RegistroEfectivo getIdRegistroEfectivo() {
        return idRegistroEfectivo;
    }

    public void setIdRegistroEfectivo(RegistroEfectivo idRegistroEfectivo) {
        this.idRegistroEfectivo = idRegistroEfectivo;
    }

    public int getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(int numReporte) {
        this.numReporte = numReporte;
    }

    @Override
    public String toString() {
        return "ReportesEfectivo{" +
                "idReporte=" + idReporte +
                ", descripcion='" + descripcion + '\'' +
                ", idRegistroEfectivo=" + idRegistroEfectivo +
                ", numReporte=" + numReporte +
                '}';
    }
}
