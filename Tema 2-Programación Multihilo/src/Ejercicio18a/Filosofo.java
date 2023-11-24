/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio18a;

/**
 *
 * @author guipe
 */

public class Filosofo extends Thread {

    private Tenedor izquierdo;
    private Tenedor derecho;
    private final int id;

    private void pausa() throws InterruptedException {

        try {
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
        }

    }
    
    public Filosofo(Tenedor izquierdo, Tenedor derecho, int id) {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Filofoso "+(id+1) +" pensando");
                pausa();
                System.out.println("Filofoso "+(id+1) + " cogiendo tenedor derecho");
                derecho.tomar();
                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                System.out.println("Filofoso "+(id+1) + " cogiendo tenedor izquierdo");
                izquierdo.tomar();
                System.out.println("Filofoso "+(id+1) + " comiendo");
                pausa();
                derecho.dejar();
                izquierdo.dejar();
            }
        } catch (InterruptedException e) {
            System.out.println("Filofoso "+(id+1) + " saliendo por una interrupción");
        }
    }
}
