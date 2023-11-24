/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio18a;


/**
 *
 * @author guipe
 */
public class App {

    public static void main(String[] args) {

        int numeroFilosofos = 5;
        Tenedor[] tenedores = new Tenedor[numeroFilosofos]; //Inicialmente cada objeto en Java tiene el valor predeterminado null
        Filosofo[] filosofos = new Filosofo[numeroFilosofos];
        for (int i = 0; i < numeroFilosofos; i++) {         //Crea un nuevo objeto Tenedor para cada posición del array.
            tenedores[i] = new Tenedor();
        }
        //Indico que Tenedores tiene a su derecha e izquierda cada Filósofo
        for (int i = 0; i < numeroFilosofos; i++) {
            int tenedorDerecho = i;
            int tenedorIzquierdo = (i + 1) % numeroFilosofos;
            filosofos[i] = new Filosofo(tenedores[tenedorIzquierdo], tenedores[tenedorDerecho], i);
            
            filosofos[i].start();
        }

    }
}
