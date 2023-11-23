/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio15;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author guipe
 */
public class Main {

    public static void main(String[] args) {

        Imprimir imp = new Imprimir();
// Declaración de 2 threads
        PingPong t1 = new PingPong("PING ", imp,1);
        PingPong t2 = new PingPong("PONG ", imp,2);
// Activación
        t1.start();
        t2.start();
// Espera 5 segundos
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            return;
        }
// Finaliza la ejecución de los threads
        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo PING finalizado correctamente");
        t2.interrupt();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo PONG finalizado correctamente");
          
    }
}
