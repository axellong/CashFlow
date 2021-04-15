package logic.Model;

import entity.Usuario;

public class UserTable {

    private String nombre;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private Usuario usuario;

    public UserTable(){

    }

    public UserTable(Usuario usuario){
        this.usuario = usuario;
        nombre = usuario.getNombre();
        nombreUsuario = usuario.getUsername();
        email = usuario.getEmail();
        contrasena = usuario.getPassword();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
