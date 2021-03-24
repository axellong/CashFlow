package entity;

public class SubCategoria {

    private int idSubCategoria;
    private String nombreSubCategoria;
    private int idCategoria;

    public SubCategoria(int idSubCategoria, String nombreSubCategoria, int idCategoria) {
        this.idSubCategoria = idSubCategoria;
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
}
