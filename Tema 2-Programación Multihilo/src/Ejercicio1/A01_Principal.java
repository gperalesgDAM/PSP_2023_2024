/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author guipe
 */
public class A01_Principal {

    public static void main(String[] args) {
        int numero_hilos = 5;
        String nombre = "";
        A01_Hilo[] arrayHilos = new A01_Hilo[numero_hilos];
        for (int i = 0; i < numero_hilos; i++) {
            nombre = "hilo_" + (i + 1);
            arrayHilos[i] = new A01_Hilo(nombre);
            arrayHilos[i].start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

    }
}


