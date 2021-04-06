package entity;

public class Person {
    public String clasificacion;
    public String categoria;
    public String subCategoria;

    public Person(String clasificacion, String categoria, String subCategoria) {
        this.clasificacion = clasificacion;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }
}
