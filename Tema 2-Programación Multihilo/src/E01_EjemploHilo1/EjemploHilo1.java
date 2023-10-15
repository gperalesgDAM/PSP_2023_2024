/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E01_EjemploHilo1;

/**
 *
 * @author guipe
 */
public class EjemploHilo1 extends Thread {

    EjemploHilo1(String nombre) {
        super(nombre);
        System.out.println("creando hilo: " + getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo: " + getName() + " c: " + i);
        }
    }

    public static void main(String[] args) {

        EjemploHilo1 h1 = new EjemploHilo1("Hilo 1");
        EjemploHilo1 h2 = new EjemploHilo1("Hilo 2");
        EjemploHilo1 h3 = new EjemploHilo1("Hilo 3");

        h1.start();
        h2.start();
        h3.start();
    }
}
