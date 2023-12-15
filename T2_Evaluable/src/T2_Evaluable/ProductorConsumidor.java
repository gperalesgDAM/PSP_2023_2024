package T2_Evaluable;
//Este programa finaliza transcurrido un tiempo en el main que activa un bit de parada 
//de la secuencia. Hasta que no se haya vaciado la cola por completo no se finalizará.

public class ProductorConsumidor {

    private static final int CAPACIDAD_MAXIMA = 15;  //Limite de valor que tiene el buffer
    private static final int CONSUMIDORES = 20;
    private static final int PRODUCTORES = 30;

    public static void main(String[] args) throws InterruptedException {

        Monitor saf = new Monitor(CAPACIDAD_MAXIMA, true);//true: FIFO, false: LIFO

        // Crear un array de hilos
        Consumidor[] c = new Consumidor[CONSUMIDORES];
        Productor[] p = new Productor[PRODUCTORES];
        Thread[] tc = new Thread[CONSUMIDORES];
        Thread[] tp = new Thread[PRODUCTORES];
        ThreadGroup grupoC = new ThreadGroup("Consumidores");
        ThreadGroup grupoP = new ThreadGroup("Productores");
        for (int i = 0; i < PRODUCTORES; i++) {
            String nombre = "Productor_" + i;
            p[i] = new Productor(saf);
            tp[i] = new Thread(grupoP, p[i], nombre);
        }
        for (int i = 0; i < CONSUMIDORES; i++) {
            String nombre = "Consumidor_" + i;
            c[i] = new Consumidor(saf);
            tc[i] = new Thread(grupoC, c[i], nombre);
        }
        int indice;
        if (PRODUCTORES > CONSUMIDORES) {
            indice = PRODUCTORES;
        } else {
            indice = CONSUMIDORES;
        }
        for (int i = 0; i < indice; i++) {
            if (i < PRODUCTORES) {
                tp[i].start();
            }
            if (i < CONSUMIDORES) {
                tc[i].start();
            }
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }
        //Pasado el tiempo de simulación se envia señal de paro de secuencia
        saf.setFinSecuencia(true);
        //Se espera a que finalicen todos los hilos

        for (int i = 0; i < indice; i++) {
            if (i < PRODUCTORES) {
                tp[i].join();
            }
            if (i < CONSUMIDORES) {
                tc[i].join();
            }

        }
        System.out.println("Simulación finalizada correctamente");

    }

}








