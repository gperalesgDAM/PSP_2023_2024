/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9a;

import java.util.logging.Level;
import java.util.logging.Logger;


public class E01_Main {

    public static void main(String[] args) {
        System.out.println("Hilo principal ejecutandose: ");

        //creamos un hilo con una clase propia
        E01_MiHilo miHilo = new E01_MiHilo("Hilo1");

        //construimos un hilo con el objeto que hemos creado
        Thread hilo1 = new Thread(miHilo,"hilo1");

        //comenzamos la ejecucion del hilo
        hilo1.start();
        //hilo1.run();

        try {
            //pausamos la ejecucion del hilo principal
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(E01_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo principal terminado ");
    }
}
