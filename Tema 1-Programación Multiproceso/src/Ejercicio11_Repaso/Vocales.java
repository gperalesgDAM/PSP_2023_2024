/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11_Repaso;

/**
 *
 * @author guipe
 */
public class Vocales {

    public static void main(String[] args) {
        String proceso = args[0];
        char vocal = args[1].charAt(0); //Convierto a Char la vocal
        String input = args[2];

        int contador = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == vocal || input.charAt(i) == Character.toUpperCase(vocal)) {
                contador++;
            }

        }
        System.out.println("El proceso " + proceso + " ha encontrado " + contador + " veces la vocal " + vocal);
    }
}
