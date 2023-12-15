package T2_Evaluable;

import java.util.ArrayList;

class Monitor {

    private ArrayList<Integer> colaNumeros = new ArrayList<>();
    //private static final int CAPACIDAD_MAXIMA = 10;
    final int CAPACIDAD;
    private boolean fifo = false;
    private boolean finSecuencia = false;

    public Monitor(int CAPACIDAD, boolean fifo) {
        this.CAPACIDAD = CAPACIDAD;
        this.fifo = fifo;
    }

    public boolean comprobarLista(int numero) {
        return colaNumeros.contains(numero);
    }

    public synchronized void setFinSecuencia(boolean finSecuencia) {
        this.finSecuencia = finSecuencia;
    }

    public boolean isFinSecuencia() {
        return finSecuencia;
    }

    public synchronized boolean isColaVacia() {
        return colaNumeros.isEmpty();
    }

    public synchronized void coger(String hilo, String grupo) {
        //Si la cola se encuentra vacía envía el hilo a la cola de espera

        while (isColaVacia()) {//sale cuando colaVacia es falso

            if (!finSecuencia) {
                try {
                    wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                notifyAll();
                break;
            }
        }
        if (!isColaVacia()) {
            if (fifo) {
                System.out.println(hilo + " del grupo " + grupo + " Consume el número " + colaNumeros.get(0));
                colaNumeros.remove(0); // Elimina el primer elemento
            } else {
                System.out.println(hilo + " del grupo " + grupo + " Consume el número " + colaNumeros.get(colaNumeros.size() - 1));
                colaNumeros.remove(colaNumeros.size() - 1); // Elimina el último elemento

            }
            imprimirCola();
        }
        notifyAll();
        //return (numero);
    }

    public synchronized void dejar(int num, String hilo, String grupo) {

        while (colaNumeros.size() >= CAPACIDAD) {
            try {
                wait(5000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(hilo + " del grupo " + grupo + " produce el número " + num);
        colaNumeros.add(num); // Agrega el número al final de la cola
        imprimirCola();
        notifyAll();

    }

    public void imprimirCola() {
        if (!colaNumeros.isEmpty()) {
            System.out.println("Cola: " + colaNumeros);
        } else {
            System.out.println("Cola vacia");
        }
    }

}
