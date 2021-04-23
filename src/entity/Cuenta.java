package entity;

import java.util.HashSet;
import java.util.Set;

public class Cuenta {
    private int id_Cuenta;
    private int cuenta;
    private Set<RegistroIndicadores> registroIndicadores = new HashSet<RegistroIndicadores>();

    public Cuenta() {
    }

    public Cuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public Set<RegistroIndicadores> getRegistroIndicadores() {
        return registroIndicadores;
    }

    public void setRegistroIndicadores(Set<RegistroIndicadores> registroIndicadores) {
        this.registroIndicadores = registroIndicadores;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuenta=" + cuenta +
                '}';
    }
}
