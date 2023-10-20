/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author guipe
 */
public class Principal {
        public static void main(String[] args) {
        int numHilos = 0;
        System.out.println("¿Cuántos hilos quieres crear? ");
        Scanner lector = new Scanner(System.in);
        numHilos = (int) lector.nextInt();
        Hilo[] arrayHilos = new Hilo[numHilos];
        for (int i = 0; i < numHilos; i++) {
            arrayHilos[i] = new Hilo(i + 1);	//crear hilo
            arrayHilos[i].start(); //iniciar hilo
        }
        System.out.println(numHilos+" HILOS CREADOS...");
    }
    
}
