package Ejercicio14;

import java.util.Random;

public class Supermercado {

    public static void main(String[] args) throws InterruptedException {

        int numCajas = 5;
        int numClientes = 100;
        Cliente clientes[] = new Cliente[numClientes];
        Caja cajas[] = new Caja[numCajas];
//
        for (int a = 0; a < numCajas; a++) {
            cajas[a] = new Caja(a);
        }

        for (int b = 0; b < numClientes; b++) {
            int j = new Random().nextInt(numCajas);
            clientes[b] = new Cliente(b, cajas[j]);
            clientes[b].start();
        }

        try {
            for (int i = 0; i < numClientes; i++) {
                clientes[i].join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Supermercado cerrado.");
        System.out.println("Ganancias: " + Resultados.ganancias);
        System.out.println("Tiempo medio de espera: "
                + (Resultados.tiempoEspera / Resultados.clientesAtendidos));

    }

}
