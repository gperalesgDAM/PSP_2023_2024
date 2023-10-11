/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E02_FileOutputStream {
    public static void main(String[] args) {
        
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo2.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;
        
        
        //escribir un byte dentro del archivo
        
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(rutaArchivoYNombre);
            fos.write(65);
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            try {
                fos.close();
            } catch (IOException ex1) {
                Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
                //escribir una cadena de texto en un archivo con FileOutputStream
                
        String nombreArhivo2 = "\\archivo3.txt";
        String rutaArchivoYNombre2 = carpeta + nombreArhivo2;
        FileOutputStream fos2 = null;

        try {
            fos2 = new FileOutputStream(rutaArchivoYNombre2);
            String cadema = "Hola que tal esás?";

            byte[] matrizByte = cadema.getBytes(); //convertimos una cadena de texto a una matriz de byte

            fos2.write(matrizByte);
            fos2.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            try {
                fos2.close();
            } catch (IOException ex1) {
                Logger.getLogger(E02_FileOutputStream.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
        
        

    }
}
