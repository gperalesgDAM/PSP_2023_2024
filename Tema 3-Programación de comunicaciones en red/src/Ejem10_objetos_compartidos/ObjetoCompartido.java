package Ejem10_objetos_compartidos;



public class ObjetoCompartido {

    private int numero;
    private boolean acabo;
    private int ganador;

    public ObjetoCompartido(int numero) {
        this.numero = numero;
        this.acabo = false;
    }

    public boolean seAcabo() {
        return acabo;
    }

    public int getGanador() {
        return ganador;
    }

    public synchronized String nuevaJugada(int jugador, int numPropuesto) {
        String cad = "";
        if (!seAcabo()) {
            if (numPropuesto > numero) {
                cad = "Número demadiado grande";
            } else if (numPropuesto < numero) {
                cad = "Número demadiado bajo";
            } else { // ha acertado
                cad = "Jugador " + jugador
                        + " gana, adivino el numero: " + numero;
                acabo = true;
                ganador = jugador;
            }
        } else {
            cad = "Jugador: " + ganador + " adivinó el número: " + numero;
        }
        return cad;
    }

}
