/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E02_EjemploNombres;

/**
 *
 * @author guipe
 */
public class EjemploNombres extends Thread {

    EjemploNombres(String nombre) {
        super(nombre);
    }

    EjemploNombres() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo: " + getName() + " c: " + i);
        }
    }

    public static void main(String[] args) {

        EjemploNombres h1 = new EjemploNombres("Hilo 1");

        EjemploNombres h2 = new EjemploNombres();
        h2.setName("Hilo 2");

        h1.start();
        h2.start();

        System.out.println("nombre del primer hilo: " + h1.getName());
        System.out.println("nombre del segundo hilo: " + h2.getName());

    }
}

