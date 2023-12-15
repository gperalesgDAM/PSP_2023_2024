package Ejercicio2;

import java.util.ArrayList;

class Puestos {

    private ArrayList<Coches> colaCoches;
    private int idPuesto;
    private String nombre;
    private int precioLavado = 2;
    private int gananciasAcumuladas;
    private int cochesLimpiados;
    private long tiempoEsperaAcumulado;

    public Puestos(int idPuesto) {
        this.idPuesto = idPuesto;
        colaCoches = new ArrayList<Coches>();
        nombre = "Puesto_" + this.idPuesto;

    }

    public int getGananciasAcumuladas() {
        return gananciasAcumuladas;
    }

    public int getCochesLimpiados() {
        return cochesLimpiados;
    }

    public long getTiempoEsperaAcumulado() {
        return tiempoEsperaAcumulado;
    }

    public synchronized long IncrementoTiempoEsperaAcumulado(long tiempo) {
        return tiempoEsperaAcumulado = tiempoEsperaAcumulado + tiempo;

    }

    public String getNombre() {
        return nombre;
    }

    synchronized public void productor(Coches nuevoCoche) throws InterruptedException {

        colaCoches.add(nuevoCoche);
        System.out.println("-> " + nuevoCoche.getNombre() + " esperando en cola de " + nombre);
        mostrarCola();
        while (colaCoches.get(0).getIdCliente() != nuevoCoche.getIdCliente()) {
            try {
                wait();

            } catch (InterruptedException interruptedException) {
            }
        }

    }

    synchronized public void consumidor(Coches nuevoCoche) throws InterruptedException {

        colaCoches.remove(0);
        mostrarCola();
        System.out.println("<- " + nuevoCoche.getNombre() + " ha salido de la cola de " + nombre);
        gananciasAcumuladas = gananciasAcumuladas + precioLavado;
        cochesLimpiados++;
        notify();
    }

    public void mostrarCola() {
        System.out.print("Cola de: " + nombre + ": ");
        for (int i = 0; i < colaCoches.size(); i++) {
            int idCoche = colaCoches.get(i).getIdCliente();
            System.out.print(idCoche + " ");
        }
        System.out.println("");
    }

}
