/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11_Repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class Lanzador {

    public static void main(String[] args) {

        Process[] procesosVocales = new Process[5];         //  ==> Con un array
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el texto a analizar: ");
        String input = scanner.nextLine();

        scanner.close(); // Cierra el Scanner al finalizar
        for (int j = 1; j <= 5; j++) {
            //Crear los cinco procesos y en función del número seleccionar una vocal para enviar al proceso hijo
        }

        // Esperar a que todos los procesos que buscan vocales se completen

        
        
        //Crear un nuevo proceso que convierta a mayusculas
        
        //Comprobar si hay carpeta. Si no hay crearla
        
        //Leer el fichero convertido a mayusculas en el proceso hijo
        






}
}