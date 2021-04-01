package entity;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String username;
    private String password;
    private  boolean credencial;
    private String email;

    public Usuario(int idUsuario, String nombre, String username, String password, boolean credencial, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.credencial = credencial;
        this.email = email;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCredencial() {
        return credencial;
    }

    public void setCredencial(boolean credencial) {
        this.credencial = credencial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", credencial=" + credencial +
                ", email='" + email + '\'' +
                '}';
    }
}
