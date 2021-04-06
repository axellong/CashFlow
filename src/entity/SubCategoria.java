package entity;

public class SubCategoria {

    private int idSubCategoria;
    private String nombreSubCategoria;
    private Categoria id_Categoria;

    public SubCategoria(String nombreSubCategoria, Categoria idCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
        this.id_Categoria = idCategoria;
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

    public Categoria getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(Categoria id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    @Override
    public String toString() {
        return "SubCategoria{" +
                "idSubCategoria=" + idSubCategoria +
                ", nombreSubCategoria='" + nombreSubCategoria + '\'' +
                ", id_Categoria=" + id_Categoria +
                '}';
    }
}
