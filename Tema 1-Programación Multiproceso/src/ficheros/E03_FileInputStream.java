/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E03_FileInputStream {
    public static void main(String[] args) {
        
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo2.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;

        FileInputStream fis = null;
        int dato = 0;

        try {
            fis = new FileInputStream(rutaArchivoYNombre);
//            //leemos un caracter
//            dato = fis.read();
//            System.out.println((char)dato);

            //leer todo el contenido
            while ((dato = fis.read()) != -1) {
                System.out.print((char) dato);
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(E03_FileInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E03_FileInputStream.class.getName()).log(Level.SEVERE, null, ex);
            try {
                fis.close();
            } catch (IOException ex1) {
                Logger.getLogger(E03_FileInputStream.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        System.out.println("");
    }
}
