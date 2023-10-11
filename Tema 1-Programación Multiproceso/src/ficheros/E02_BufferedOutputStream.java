/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedOutputStream;
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
public class E02_BufferedOutputStream {
    
    public static void main(String[] args) {
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo4.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;


        
        //escribimos de una manera mas eficiente una matriz de byte o un flujo utilizando BufferedOutputStream
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        String texto = "Hola que tal estas? Hola que tal estas? Hola que tal estas? Hola que tal estas?Hola que tal estas? ";
        byte[] matriz = texto.getBytes();

        try {
            fos = new FileOutputStream(rutaArchivoYNombre);
            bos = new BufferedOutputStream(fos);
            bos.write(matriz);
            bos.flush(); //Limpiamos el buffer
            bos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(E02_BufferedOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E02_BufferedOutputStream.class.getName()).log(Level.SEVERE, null, ex);

            try {
                fos.close();
                bos.close();
            } catch (IOException ex1) {
                Logger.getLogger(E02_BufferedOutputStream.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }
}
