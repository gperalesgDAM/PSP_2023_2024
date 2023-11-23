/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio16;


/**
 *
 * @author guipe
 */


public class Imprimir {

    private int ordenPalabra=0;
    private int numeroDePalabras=0;


    public int getOrdenPalabra() {
        return ordenPalabra;
    }

    public int getNumeroDePalabras() {
        return numeroDePalabras;
    }

    public void setNumeroDePalabras(int numeroDePalabras) {
        this.numeroDePalabras = numeroDePalabras;
    }


    public void impresion(String texto) {

        System.out.println(texto);

        if (ordenPalabra<numeroDePalabras-1){
            ordenPalabra++;
        }else{
            ordenPalabra=0;
        }
    }

}
