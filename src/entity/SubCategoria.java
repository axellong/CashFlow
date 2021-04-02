package entity;

public class SubCategoria {

    private int idSubCategoria;
    private String nombreSubCategoria;
    private int idCategoria;

    public SubCategoria( String nombreSubCategoria, int idCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
        this.idCategoria = idCategoria;
    }

    public SubCategoria() {
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public String getNombreSubCategoria() {
        return nombreSubCategoria;
    }

    public void setNombreSubCategoria(String nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "SubCategoria{" +
                "idSubCategoria=" + idSubCategoria +
                ", nombreSubCategoria='" + nombreSubCategoria + '\'' +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
