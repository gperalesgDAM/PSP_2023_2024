/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T1_Evaluable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guipe
 */
public class E05_B {

    public static void main(String[] args) throws IOException {

        String rutaArchivo1 = args[0]; //OPCION 1: Pasando el directorio donde se ejecuta el programa lanzador como argumento
        String rutaArchivo2 = "..\\.."; //OPCION 2: El proceso hijo debera ubicarse dos rutas hacia atras para acceder al archivo resultado.txt en la raiz del programa lanzador1 
        String rutaArchivo3 = "C:\\Users\\guipe\\NetBeansProjects\\PSP\\T1_Evaluable";//OPCION 3: Poner directamente la ruta donde se creará el archivo
        String nombreArhivo = "\\resultado.txt";
        //ELIJO UNA DE LAS TRES OPCIONES INDICADAS
        String rutaArchivoYNombre = rutaArchivo1 + nombreArhivo;       //OPCION 1:
        //String rutaArchivoYNombre = rutaArchivo2 + nombreArhivo;    //OPCION 2:
        //String rutaArchivoYNombre = rutaArchivo3 + nombreArhivo;    //OPCION 3:

        int numAleatorio;

        numAleatorio = (int) (Math.random() * 100);
        FileWriter fw = new FileWriter(rutaArchivoYNombre);

        BufferedWriter bw = new BufferedWriter(fw);
        //bw.write(Integer.toString(numAleatorio));
        fw.write(Integer.toString(numAleatorio));
        bw.close();
        fw.close();

    }
}
