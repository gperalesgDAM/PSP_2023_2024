/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MiHilo2 extends Thread {

    //constructor
    public MiHilo2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Inicio del hilo: " + getName());

        try {
            Thread.sleep(2000); //Simulamos una carga en el hilo
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo2.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Fin del hilo: " + getName());
    }

}
