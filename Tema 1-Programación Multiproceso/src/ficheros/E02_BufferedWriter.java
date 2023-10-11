/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E02_BufferedWriter {
    
    public static void main(String[] args) {
        
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo3.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(rutaArchivoYNombre);
            bw = new BufferedWriter(fw);

            //escribimos
            bw.write("Bienvenido al curso de java");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(E02_BufferedWriter.class.getName()).log(Level.SEVERE, null, ex);
            try {
                bw.close();
            } catch (IOException ex1) {
                Logger.getLogger(E02_BufferedWriter.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }
}
