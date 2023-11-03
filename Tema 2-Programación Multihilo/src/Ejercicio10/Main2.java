/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main2 {

    public static void main(String[] args) {
        System.out.println("El hilo principal ha comenzado su ejecucion");
        MiHilo2 thread1 = new MiHilo2("Hilo1");
        MiHilo2 thread2 = new MiHilo2("Hilo2");



        try {
            thread1.start();
            thread1.join(); //estamos haciendo que el hilo pricipal espera a que el hilo1 acabe su ejecucion
            thread2.start();
            thread2.join(); //estamos haciendo que el hilo pricipal espera a que el hilo2 acabe su ejecucion
        } catch (InterruptedException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        System.out.println("El hilo principal ha acabado su ejecucion");
    }
}
