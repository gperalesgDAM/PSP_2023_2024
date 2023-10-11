/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E03_BufferedReader {
    
    public static void main(String[] args) {
        
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo3.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;
        
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";

        try {
            fr = new FileReader(rutaArchivoYNombre);
            br = new BufferedReader(fr);

            //leemos el archivo linea a linea
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(E03_BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E03_BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(E03_BufferedReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
