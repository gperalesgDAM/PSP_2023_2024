/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio15;

public class PingPong extends Thread {

    private String palabra; // Lo que va a escribir.
    private Imprimir imp;
    private int ordenPalabra;

    public PingPong(String palabra, Imprimir imp, int ordenPalabra) {
        this.palabra = palabra;
        this.imp = imp;
        this.ordenPalabra = ordenPalabra;

    }

    @Override
    public void run() { //Se sobrescribe run() de Thread
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (imp) {
                    while (ordenPalabra != imp.getOrdenPalabra()) {
                        imp.wait(); //esperar a que llegue un notify
                    }
                    imp.impresion(palabra);
                    imp.notify(); //aviso que ya he usado el objeto

                }

            }
        } catch (InterruptedException ie) {
            System.out.println("Hilo interrumpido mientras estaba en espera");
        }
    }
}
