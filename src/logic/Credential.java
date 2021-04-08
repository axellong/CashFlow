package logic;

import entity.Usuario;

public class Credential {

    private static Usuario user;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Credential.user = user;
    }
}
