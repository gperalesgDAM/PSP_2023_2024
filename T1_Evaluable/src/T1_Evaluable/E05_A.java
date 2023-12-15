/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T1_Evaluable;

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
public class E05_A {

    public static int getResultadoFichero(String nombreFichero) {
        int numero = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            String linea = br.readLine();
            numero = Integer.parseInt(linea);
            return numero;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return numero;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //String line;
        int resultado = 0;
        String directorioActual = System.getProperty("user.dir");

        File directorio = new File(".\\build\\classes");
        ProcessBuilder pb = new ProcessBuilder("java", "T1_Evaluable.E05_B", directorioActual);

        pb.directory(directorio);
        String line = "";

        System.out.println("Pulsar tecla para obtener aleatorio, entre 0-100 fin para terminar");
        while (!line.equals("fin")) {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            line = entrada.readLine();
            if (line.equals("fin")) {
                break;
            }

            Process p = pb.start();

            p.waitFor();
            resultado = getResultadoFichero("resultado.txt");
            System.out.println(resultado);
        }
    }
}
