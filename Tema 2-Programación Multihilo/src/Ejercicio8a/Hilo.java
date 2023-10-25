/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8a;

/**
 *
 * @author guipe
 */
public class Hilo implements Runnable {

    //atributos
    private String mensajeHilo;

    //constructor
    public Hilo(String mensaje) {
        this.mensajeHilo = mensaje;
    }

    @Override
    public void run() {

        System.out.println("Hola mundo, soy el hilo " + Thread.currentThread().getName() + " con Id: " + Thread.currentThread().getId()
                + " el mensaje desde el main es: " + mensajeHilo);

    }

}
