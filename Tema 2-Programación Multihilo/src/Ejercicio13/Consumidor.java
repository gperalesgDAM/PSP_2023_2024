/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    //atributos
    private final List<Integer> listaCompartida;
    private final int ITERACIONES;

    //constructor
    public Consumidor(List<Integer> listaCompartida, int iter) {
        this.listaCompartida = listaCompartida;
        this.ITERACIONES = iter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= ITERACIONES; i++) {
            //   synchronized (listaCompartida) {
            if (!listaCompartida.isEmpty()) {
                int numero = listaCompartida.remove(0);
                System.out.println("Consumidor ha eliminado el numero: " + numero);
            }
            //   }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
