/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E06B_OrdenarNumeros {

    public static void main(String[] args) {

        File directorio = new File(".\\build\\classes");
        ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.E06B_Aleatorios");
        pb.directory(directorio);

        try {
            Process p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String lineaProceso = null;

            while ((lineaProceso = br.readLine()) != null) { //Cuando termina de leer linea = null

                //Con Split, cada vez que hay un espacio interpreto que es un nuevo String del array datos[]
                String datos[] = lineaProceso.split(" ");
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
            try {
                // Esperar a que el proceso termine (opcional)
                int resultado = p.waitFor();

                if (resultado == 0) {
                    System.out.println("El programa Aleatorios se ejecutó correctamente.");
                } else {
                    System.out.println("Error al ejecutar el programa Aleatorios.");
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(E06B_OrdenarNumeros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

