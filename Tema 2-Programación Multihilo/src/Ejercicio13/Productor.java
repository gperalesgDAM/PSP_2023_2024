/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor implements Runnable {

    //atributos
    private final List<Integer> listaCompartida;
    private final int ITERACIONES;

    //constructor
    public Productor(List<Integer> listaCompartida, int iter) {
        this.listaCompartida = listaCompartida;
        this.ITERACIONES = iter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= ITERACIONES; i++) {
            //    synchronized (listaCompartida) {
            listaCompartida.add(i);
            System.out.println("El productor agrego un numero a la lista: " + i);
            //     }
            try {
                Thread.sleep(10); //Simulamos una carga de proceso
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
