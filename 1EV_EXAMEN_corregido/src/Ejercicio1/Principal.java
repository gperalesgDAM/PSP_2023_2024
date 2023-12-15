/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guipe
 */
public class Principal {

    public static Boolean nuevaCarpeta(String ruta) {

        File carpeta = new File(ruta);

        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {   //Crea el directorio nombrado por carpeta
                System.out.println("La carpeta " + carpeta.getName() + " se ha creado correctamente");
                return true;
            } else {
                System.out.println("La carpeta " + carpeta.getName() + " no se ha podido crear");
                return false;
            }
        } else {
            System.out.println("La carpeta " + carpeta.getName() + " ya existe");
            return true;
        }

    }

    public static String getResultadoFichero(String rutaCompleta) {
        String linea = "";
        try {
            FileInputStream fichero = new FileInputStream(rutaCompleta);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            linea = br.readLine();

            return linea;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + rutaCompleta);
        } catch (IOException e) {
            System.out.println("No hay nada en " + rutaCompleta);
        }
        return linea;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //Creo los elementos de la ruta que pasaré al proceso hijo como parámetros
        String directorioActual = System.getProperty("user.dir");
        String nuevaCarpeta = "//Archivos";
        String fichero = "//texto.txt";

        //Comprobamos como la dirección de raiz del proceso hijo es diferente a la del proceso padre
        File archivo = new File(directorioActual);
        System.out.println(archivo.getPath());

        String rutaCompleta = directorioActual + nuevaCarpeta + fichero;
        //Creo, configuro el nuevo proceso y lo arranco esperando a que termine
        File directorio = new File(".\\build\\classes");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1.Escritura", directorioActual, nuevaCarpeta, fichero);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.directory(directorio);
        Process p = pb.start();
        p.waitFor();
        //Capturo el valor que ha escrito el proceso hijo
        String texto = getResultadoFichero(rutaCompleta);
        System.out.println("El texto escrito en el archivo es: " + texto);

    }
}
