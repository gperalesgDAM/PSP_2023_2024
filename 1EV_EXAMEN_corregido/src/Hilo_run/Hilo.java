/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilo_run;

/**
 *
 * @author guipe
 */
public class Hilo extends Thread {

    Hilo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {

        System.out.println("Hola mundo, soy el hilo " + Thread.currentThread().getName());
        try {

            Thread.sleep(8000);
        } catch (InterruptedException ex) {
        }
    }
}
