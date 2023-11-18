/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        //creamos una lista sincronizada

        //COMPROBAR DIFERENCIAS SI SE USA LISTA SINCRONIZADAS Y LISTAS SIN SINCRONIZAR. CON LOS METODOS SIN SINCRONIZAR
        List<Integer> listaCompartida = Collections.synchronizedList(new ArrayList<>());//<--LISTA SINCRONIZADA
        //ArrayList<Integer> listaCompartida = new ArrayList<>();//<--LISTA SIN SINCRONIZADA

        final int ITERACIONES = 500;
        Thread productorThread = new Thread(new Productor(listaCompartida, ITERACIONES));
        Thread consumidorThread = new Thread(new Consumidor(listaCompartida, ITERACIONES));

//        //iniciamos los hilos (el orden es importante)
        productorThread.start();
        consumidorThread.start();

        try {
            productorThread.join();
            consumidorThread.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("En la lista hay " + listaCompartida.size() + " elementos");
    }
}
