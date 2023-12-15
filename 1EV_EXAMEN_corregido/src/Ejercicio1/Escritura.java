/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;



import static Ejercicio1.Principal.nuevaCarpeta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author guipe
 */
public class Escritura {

    public static void main(String[] args) throws IOException {
        String directorioPadre = args[0];
        String nuevaCarpeta = args[1];
        String fichero = args[2];
        //Comprobamos como la dirección de raiz del proceso hijo es diferente a la del proceso padre
        String directorioActual = System.getProperty("user.dir");
        File archivo = new File(directorioActual);
        System.out.println(archivo.getPath());

        if (nuevaCarpeta(directorioPadre + nuevaCarpeta)) {
            //OPCION 1: Pasando el directorio donde se ejecuta el programa lanzador como argumento
            String rutaCompleta = directorioPadre + nuevaCarpeta + fichero;
            //OPCION 2: El proceso hijo debera ubicarse dos rutas hacia atras para acceder a la carpeta ARchivos situada en la raiz del proyecto donde esta texto.txt
            //String rutaCompleta= "..\\..\\Archivos\\texto.txt"; 
            //OPCION 3: Poner directamente la ruta donde se creará el archivo
            //String rutaCompleta="C:\\Users\\guipe\\PSP\\1EVP-EXAMEN\\Archivos\\texto.txt";

            System.out.println("Escribe un texto en el proceso Escritura: ");
            InputStreamReader entrada = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader(entrada);
            String texto = teclado.readLine();

            FileWriter fw = null;
            BufferedWriter bw = null;
            fw = new FileWriter(rutaCompleta);

            bw = new BufferedWriter(fw);
            fw.write(texto);
            bw.close();
            fw.close();
            System.out.println("El texto ha sido escrito correctamente");
        } else {
            System.out.println("No se pudo crear carpeta");
        }

    }

}
