/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.Scanner;

/**
 *
 * @author guipe
 */
public class E06A_Aleatorios {

    public static void main(String[] args) {
        int cantidadGenerados = 40; //Por defecto se cogen 40
            System.out.println("¿Cuantos números aleatorios quieres generar?");
            Scanner lector = new Scanner(System.in);
            cantidadGenerados = (int) lector.nextInt();
        for (int i = 0; i < cantidadGenerados; i++) {
            int numAleatorio = 0;
            numAleatorio = (int) (Math.random() * 100);
            System.out.print(numAleatorio + " ");

        }
        System.out.println("");

    }

}
