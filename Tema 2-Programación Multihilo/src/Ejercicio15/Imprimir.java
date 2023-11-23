/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio15;

/**
 *
 * @author guipe
 */

public class Imprimir {

    private int ordenPalabra = 1;

    public int getOrdenPalabra() {
        return ordenPalabra;
    }

    public void impresion(String texto) {

        System.out.println(texto);
        if (ordenPalabra == 1) {
            ordenPalabra = 2;
        } else {
            ordenPalabra = 1;

        }
    }

}
