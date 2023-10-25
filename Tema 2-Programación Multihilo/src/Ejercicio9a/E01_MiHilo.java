/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9a;


public class E01_MiHilo implements Runnable {

    //atributos
    private String nombreHilo;

    //constructor
    public E01_MiHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        System.out.println("Comenzando la ejecucion del hilo: " + nombreHilo);
        try {
            for (int i = 5; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println("El hilo "+ nombreHilo+ " finalizara en: " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminando la ejecucion del hilo: " + nombreHilo);
        System.out.println(Thread.currentThread().toString());
    }

}
