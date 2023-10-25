package Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {

    //constructores
//    Hilo() {
//    }

    Hilo(String nombre) {
        super(nombre);
    }

    Hilo(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {

        System.out.println("Datos del Hilo: " + Thread.currentThread().toString());
        try {

            int numAleatorio = 0;
            numAleatorio = (int) (Math.random() * 10000);
            sleep(numAleatorio);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
