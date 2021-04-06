package entity;

public class ReportesIndicadores {
    private int idReporte;
    private String descripcion;
    private RegistroIndicadores idRegistroIndicadores;
    private int numReporte;

    public ReportesIndicadores(String descripcion, RegistroIndicadores idRegistroIndicadores, int numReporte) {
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

    public RegistroIndicadores getIdRegistroIndicadores() {
        return idRegistroIndicadores;
    }

    public void setIdRegistroIndicadores(RegistroIndicadores idRegistroIndicadores) {
        this.idRegistroIndicadores = idRegistroIndicadores;
    }

    public int getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(int numReporte) {
        this.numReporte = numReporte;
    }

    @Override
    public String toString() {
        return "ReportesIndicadores{" +
                "idReporte=" + idReporte +
                ", descripcion='" + descripcion + '\'' +
                ", idRegistroIndicadores=" + idRegistroIndicadores +
                ", numReporte=" + numReporte +
                '}';
    }
}
