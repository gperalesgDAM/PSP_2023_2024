/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E06A_OrdenarNumeros {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            String lineaTeclado = null;
            System.out.println("Introduce series de números para ordenar: ");
            try {
                while ((lineaTeclado = br.readLine()) != null) {
                
                //Con Split, cada vez que hay un espacio interpreto que es un nuevo String del array datos[]
                String datos[] = lineaTeclado.split(" ");
                int numeros[] = new int[datos.length];
                for (int i = 0; i < numeros.length; i++) {
                    //Parseo los numeros que actualmente son de tipo String y los convierto a enteros para ordenarlos
                    numeros[i] = Integer.parseInt(datos[i]);
                }
                Arrays.sort(numeros); //Ordenar un array de forma ascendente.
                for (int i = 0; i < numeros.length; i++) {
                    System.out.print(numeros[i] + " ");

                }
                System.out.println("");
                
            }
            } catch (NumberFormatException e) {
                //Si se introduce un caracter string que no es un entero se finaliza la ejecucion
            }

        } catch (IOException ex) {
            Logger.getLogger(E06A_OrdenarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

