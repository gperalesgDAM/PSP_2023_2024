/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E01_CrearCarpetaArchivo {

    public static void main(String[] args) {
        //String rutaArchivo = "";
        String nombreArhivo = "\\archivo.txt";
        String rutaArchivo2 = ("."); //Ruta relativa
        
        

        //creamos carpeta
        File carpeta = new File(rutaArchivo2 + "\\archivos4\\prueba");
        String rutaArchivoYNombre = carpeta + nombreArhivo;
        
        
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {   //Crea el directorio nombrado por carpeta
                System.out.println("La carpeta se ha creado correctamente");
            } else {
                System.out.println("La carpeta no se ha podido crear");
            }
        } else {
            System.out.println("La carpeta ya existe");
        }

        // Creamos un archivo de texto
        File archivo = new File(rutaArchivoYNombre);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamnte");
            } else {
                System.out.println("Error al crear el archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(E01_CrearCarpetaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
                //ver caracteristicas de la carpeta y del archivo
        System.out.println("Caracteristicas de la carpeta o directorio");
        System.out.println(carpeta.canRead());
        System.out.println(carpeta.canWrite());
        System.out.println(carpeta.exists());
        System.out.println(carpeta.getName());
        System.out.println(carpeta.getPath());
        System.out.println(carpeta.isFile());
        System.out.println(carpeta.isDirectory());

        System.out.println("Caracteristicas del archivo");
        System.out.println(archivo.canExecute());
        System.out.println(archivo.canRead());
        System.out.println(archivo.canWrite());
        System.out.println(archivo.exists());
        System.out.println(archivo.getPath());
        System.out.println(archivo.isAbsolute());
        System.out.println(archivo.isDirectory());
        System.out.println(archivo.isFile());
        System.out.println(archivo.getName());
        System.out.println(archivo.lastModified());
        System.out.println(archivo.length());
    }
}
