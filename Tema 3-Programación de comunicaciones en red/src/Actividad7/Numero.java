package Actividad7;

import java.io.Serializable;

public class Numero implements Serializable {

    private int numero1;
    private long numero2;
    private long numero3;

    public Numero(int numero) {
        super();
        this.numero1 = numero;
    }

    public Numero() {
        super();
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public long getNumero2() {
        return numero2;
    }

    public void setNumero2(long numero2) {
        this.numero2 = numero2;
    }

    public long getNumero3() {
        return numero3;
    }

    public void setNumero3(long numero3) {
        this.numero3 = numero3;
    }

}
