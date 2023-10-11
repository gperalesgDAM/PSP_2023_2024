/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E02_FileWriter {

    public static void main(String[] args) {
        
        //creamos carpeta
        String rutaArchivo = "";
        File carpeta = new File(rutaArchivo + "\\archivos");
        String nombreArhivo = "\\archivo1.txt";
        String rutaArchivoYNombre = carpeta + nombreArhivo;
        
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(rutaArchivoYNombre); //Si existe el archivo lo sobreescribe y si no lo crea
            fw.write("Hola mundo!!!");            //Sobreescribe el texto
            fw.append("\nxxxxx");       //Añade texto a lo que hay ya en el archivo
            fw.append("\nyyyyy");
            fw.close();                     //Se debe cerrar el flujo de datos para aprovechar recursos
        } catch (IOException ex) {
            try {
                fw.close();
            } catch (IOException ex1) {
                Logger.getLogger(E02_FileWriter.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(E02_FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
