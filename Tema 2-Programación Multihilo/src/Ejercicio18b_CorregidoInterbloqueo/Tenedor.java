/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio18b_CorregidoInterbloqueo;


/**
 *
 * @author guipe
 */
public class Tenedor {
    
//ATRIBUTOS
    private boolean tomado = false;
    private int id = 0;
//CONSTRUCTOR
    Tenedor(int id) {
        this.id = id;
    }
//METODOS
    public int getId() {
        return id;
    }
    
    public synchronized void tomar() {
        while (tomado) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error al tomar el tenedor");
            }
        }
        tomado = true;
    }

    public synchronized void dejar() {
        tomado = false;
        // Cambia notify por notifyAll y mira que pasa
        // Ahora rompe el interbloqueo, codigo del main del if...
        notify();
        //notifyAll();
    }

}
