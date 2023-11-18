package Ejercicio14;

import java.util.ArrayList;
import java.util.Random;

class Caja {

    private static final int MAX_TIME = 500; //Tiempo máximo de atención a cliente

    private ArrayList<Cliente> colaClientes= new ArrayList<>();;
    private int idCaja;


    public Caja(int idCaja) {
        this.idCaja = idCaja;
        colaClientes = new ArrayList<Cliente>();


    }

    public int getIdCaja() {
        return idCaja;
    }

    synchronized public void esperar(Cliente nuevoCliente) throws InterruptedException {
        colaClientes.add(nuevoCliente);
        System.out.println("-> El cliente: " + nuevoCliente.getIdCliente() + " esperando en caja:" + this.idCaja);
        while (colaClientes.get(0).getIdCliente() != nuevoCliente.getIdCliente()) {
            wait();
        }
    }

    synchronized public void atender(int pago) throws InterruptedException {
        if (hayClientesCola()) {
            Cliente cliente = colaClientes.get(0);
            colaClientes.remove(0);

            int tiempoAtencion = new Random().nextInt(MAX_TIME);
            Thread.sleep(tiempoAtencion);
            System.out.println("<- El cliente: " + cliente.getIdCliente() + " ha salido de la cola " + this.idCaja);

            Resultados.ganancias += pago;
            Resultados.clientesAtendidos++;

            notify();
        }
        System.out.println("Se ha producido un error en el control de la fila");
    }

    synchronized public void imprimir() {
        System.out.print("____Caja: " + this.idCaja + " estado de la cola: ");
        for (int i = 0; i < this.colaClientes.size(); i++) {
            System.out.print(colaClientes.get(i).getIdCliente() + " - ");
        }
        System.out.println();

    }

    private boolean hayClientesCola() {
        return (!colaClientes.isEmpty());
    }

}
