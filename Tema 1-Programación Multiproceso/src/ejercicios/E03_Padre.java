/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author guipe
 */
public class E03_Padre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Crear el proceso hijo
            File directorio = new File(".\\build\\classes");
            ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.E03_Hijo");
            pb.directory(directorio);

            System.out.println("Hola, soy el proceso padre");
            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process procesoHijo = pb.start();
            // Esperar a que el proceso hijo termine
            procesoHijo.waitFor();
            System.out.println("Proceso padre finalizado");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
