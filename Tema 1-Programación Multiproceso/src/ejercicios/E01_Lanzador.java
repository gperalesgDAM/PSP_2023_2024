package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class E01_Lanzador {

    public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
        String clase = "ejercicios.E01_Sumador";
        ProcessBuilder pb;
        try {
            String[] parametros = {"java", clase, n1.toString(), n2.toString()};
            pb = new ProcessBuilder(parametros);
            pb.directory(new File(".\\build\\classes"));
            pb.redirectError(new File("errores_lanzador.txt")); //fout
            pb.redirectOutput(new File(fichResultado));         //fout
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getResultadoFichero(String nombreFichero) {
        int suma = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            String linea = br.readLine();
            suma = Integer.parseInt(linea);
            return suma;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return suma;
    }

    public static int getSumaTotal() {
        int sumaTotal = 0;
        sumaTotal += getResultadoFichero("result1.txt");
        sumaTotal += getResultadoFichero("result2.txt");
        return sumaTotal;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        E01_Lanzador l = new E01_Lanzador();
        l.lanzarSumador(Integer.valueOf("1"), Integer.valueOf("6"), "result1.txt");
        l.lanzarSumador(Integer.valueOf("6"), Integer.valueOf("6"), "result2.txt");
        Thread.sleep(1000);
        int sumaTotal = getSumaTotal();
        System.out.println("La suma total es:" + sumaTotal);

    }
}
