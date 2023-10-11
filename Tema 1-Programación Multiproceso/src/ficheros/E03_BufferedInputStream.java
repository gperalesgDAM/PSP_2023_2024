/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedInputStream;
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
public class E03_BufferedInputStream {

    public static void main(String[] args) {
        //lecutura de arhcivo un buffer
        
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo4.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            //instancias
            fis = new FileInputStream(rutaArchivoYNombre);
            bis = new BufferedInputStream(fis);

            //creamos un buffer
            byte[] buffer = new byte[1024];
            int byteLeidos;
            
            //leemos el archivo hasta llegar al final
            while ((byteLeidos = bis.read(buffer)) != -1) {
                //convertimos los bytes leidos en una cade de texto
                String texto = new String(buffer, 0, byteLeidos);
                System.out.println(texto);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(E03_BufferedInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(E03_BufferedInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ex) {
                    Logger.getLogger(E03_BufferedInputStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(E03_BufferedInputStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
