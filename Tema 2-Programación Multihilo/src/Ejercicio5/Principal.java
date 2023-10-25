package Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        ThreadGroup grupo = new ThreadGroup("grupos de hilos");
        
        int numHilos = 20;
        
        Hilo[] arrayHilos = new Hilo[numHilos];

        for (int i = 0; i < numHilos; i++) {
            //Creación de hilos con grupo 
            if (i < numHilos / 2) {
                String nombreHilo_grupo = "HiloAgrupado"+ (i + 1);
                arrayHilos[i] = new Hilo(grupo, nombreHilo_grupo);

            } else {
                String nombreHilo_singrupo = "Hilo" + (i + 1);
                arrayHilos[i] = new Hilo(nombreHilo_singrupo);
            }

            arrayHilos[i].start();

        }

        System.out.println(numHilos + " hilos creados");
        while (Thread.activeCount() > 1) {
            System.out.println("hilos activos: " + Thread.activeCount());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
