package Ejercicio2;

import java.util.Random;

public class Lavadero {

    public static void main(String[] args) throws InterruptedException {

        int numCoches = new Random().nextInt(71) + 30;
        int numPuestos = new Random().nextInt(5) + 1;
        System.out.println("En esta simulación se contarán con: " + numCoches + " coches y " + numPuestos + " puestos");
        int tiempoLlegada = 0;
        int gananciasTotales = 0;
        int cochesLimpiadosTotales = 0;
        long tiempoEsperaAcumuladoTotal = 0;

        Coches coches[] = new Coches[numCoches];
        Puestos puestos[] = new Puestos[numPuestos];

        for (int i = 0; i < numPuestos; i++) {
            puestos[i] = new Puestos(i);
        }

        for (int i = 0; i < numCoches; i++) {
            int j = new Random().nextInt(numPuestos);
            tiempoLlegada = new Random().nextInt(1000);
            coches[i] = new Coches(i, puestos[j], tiempoLlegada);
            coches[i].start();
        }

        try {
            for (int i = 0; i < numCoches; i++) {
                coches[i].join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Lavadero cerrado.");
        //Muestra de los resultados obtenidos
        for (int i = 0; i < numPuestos; i++) {
            System.out.println("Coches limpiados en " + puestos[i].getNombre() + ": " + puestos[i].getCochesLimpiados());
            System.out.println("Ganancias en " + puestos[i].getNombre() + ": " + puestos[i].getGananciasAcumuladas());
            System.out.println("Tiempo media de espera(ms)en " + puestos[i].getNombre() + ": " + puestos[i].getTiempoEsperaAcumulado() / puestos[i].getCochesLimpiados());

            gananciasTotales = gananciasTotales + puestos[i].getGananciasAcumuladas();
            cochesLimpiadosTotales = cochesLimpiadosTotales + puestos[i].getCochesLimpiados();
            tiempoEsperaAcumuladoTotal = tiempoEsperaAcumuladoTotal + puestos[i].getTiempoEsperaAcumulado();
        }
        System.out.println("Coches limpiados totales: " + cochesLimpiadosTotales);
        System.out.println("Ganancias totales: " + gananciasTotales);
        System.out.println("Tiempo media de espera total (ms): " + tiempoEsperaAcumuladoTotal / cochesLimpiadosTotales);

    }

}
