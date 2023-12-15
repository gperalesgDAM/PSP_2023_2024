/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilo_run;

/**
 *
 * @author guipe
 */
public class E01_Main {

    public static void main(String[] args) {
        System.out.println("Hilo principal ejecutandose: ");
        Hilo miHilo = new Hilo("Hilo1");
        miHilo.run();
        try {

            Thread.sleep(6000);
        } catch (InterruptedException ex) {
        }
        System.out.println("Hilo principal terminado ");
    }
}

