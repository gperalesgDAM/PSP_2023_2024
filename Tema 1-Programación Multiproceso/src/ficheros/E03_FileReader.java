/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

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
public class E03_FileReader {
    
    public static void main(String[] args) {

        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo1.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;
        
        FileReader fr = null;
        int valor = 0; //aqui guardaremos el valor ASCII del carácter para mostrarlo por pantalla

        try {
            fr = new FileReader(rutaArchivoYNombre);

            //leemos el archivo
            valor = fr.read();
            //mientras el valor sea diferente de -1 que siga leyendo
            while (valor != -1) {
                System.out.print((char) valor); //hacemos la conversion a char para poder ver el contenido
                valor = fr.read(); //actualiamos el valor
            }

            fr.close();

        } catch (FileNotFoundException ex) { //Si el archivo no existe
            Logger.getLogger(E03_FileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E03_FileReader.class.getName()).log(Level.SEVERE, null, ex);
            try {

                fr.close();
            } catch (IOException ex1) {
                Logger.getLogger(E03_FileReader.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        System.out.println("");
    }
}
