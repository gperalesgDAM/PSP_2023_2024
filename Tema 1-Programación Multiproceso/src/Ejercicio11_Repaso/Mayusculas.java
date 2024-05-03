/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11_Repaso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class Mayusculas {

    public static void main(String[] args) {
        String mayusculas = args[0].toUpperCase();
        String ruta = args[1];
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            fw.write(mayusculas);
            bw.close();
            fw.close();
            System.out.println("El texto se ha convertido a may�sculas correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Mayusculas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
