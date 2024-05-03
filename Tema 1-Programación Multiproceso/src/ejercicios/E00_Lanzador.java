/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.File;
import java.io.IOException;


/**
 *
 * @author guipe
 */
public class E00_Lanzador {

    public static void main(String[] args) {
        try {

            // Crear un proceso para ejecutar el programa "A03_Sumador"
            File directorio = new File(".\\build\\classes");
            ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.E00_Sumador");
            pb.directory(directorio);

            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            
            //pb.inheritIO();

            // Iniciar el proceso
            Process proceso = pb.start();

            // Esperar a que el proceso termine
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
