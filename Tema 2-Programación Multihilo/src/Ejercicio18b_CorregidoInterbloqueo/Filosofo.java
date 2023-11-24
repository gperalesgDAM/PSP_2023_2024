/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio18b_CorregidoInterbloqueo;


/**
 *
 * @author guipe
 */

public class Filosofo extends Thread {

    private Tenedor segundo;
    private Tenedor primero;
    private final int id;

    private void pausa() throws InterruptedException {

        try {
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
        }

    }
    
    public Filosofo(Tenedor izquierdo, Tenedor derecho, int id) {
        this.id = id;
        if (izquierdo.getId()>derecho.getId()){
            this.primero = derecho;
            this.segundo = izquierdo;
        } else {
            this.primero = izquierdo;
            this.segundo = derecho;
        }

    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Filofoso "+(id+1) +" pensando");
                pausa();
                System.out.println("Filofoso "+(id+1) + " cogiendo tenedor primero");
                primero.tomar();
                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                }
                System.out.println("Filofoso "+(id+1) + " cogiendo tenedor segundo");
                segundo.tomar();
                System.out.println("Filofoso "+(id+1) + " comiendo");
                pausa();
                primero.dejar();
                segundo.dejar();
            }
        } catch (InterruptedException e) {
            System.out.println("Filofoso "+(id+1) + " saliendo por una interrupción");
        }
    }
}
