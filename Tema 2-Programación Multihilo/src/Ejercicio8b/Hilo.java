/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8b;


/**
 *
 * @author guipe
 */
public class Hilo implements Runnable {

    //atributos
    private String mensajeHilo;
    private int numero;

    //constructor
    public Hilo(String mensaje,int numero) {
        this.mensajeHilo = mensaje;
        this.numero = numero;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(numero * 1000);
        } catch (InterruptedException interruptedException) {
        }

        System.out.println("Hola mundo, soy el hilo " + Thread.currentThread().getName() + " con Id: " + Thread.currentThread().getId()
                + " el mensaje desde el main es: " + mensajeHilo);

    }

}
