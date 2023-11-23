/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio16;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Introduce cadena de texto a repetir: ");

        // Creación de cadena de String con las palabras de la frase
        Scanner lector = new Scanner(System.in);
        String cadena = lector.nextLine();
        //String[] palabras = cadena.split("\\s+"); // Divide la cadena en palabras usando espacios como separadores
        //\\s: Esto coincide con cualquier carácter de espacio en blanco, como espacios, tabulaciones y saltos de línea.
        //+: Esto indica que queremos coincidir con uno o más caracteres de espacio en blanco
        String[] palabras = cadena.split("\\s+");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
        int numeroDePalabras = palabras.length;

// Declaración de n hilos de la clase HiloPalabra que usan el mismo objeto de la clase Imprimir
        Imprimir imp = new Imprimir();
        imp.setNumeroDePalabras(numeroDePalabras);
        Thread[] arrayThread = new Thread[numeroDePalabras];
        for (int i = 0; i < numeroDePalabras; i++) {
            arrayThread[i] = new HiloPalabra(palabras[i], imp, i);
        }
        // Activación
        for (int i = 0; i < numeroDePalabras; i++) {
            arrayThread[i].start();
        }

// Finaliza la ejecución de los threads a los 10 seguntos
        try {
            sleep(5000);
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < numeroDePalabras; i++) {
            arrayThread[i].interrupt();
            try {
                arrayThread[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
