package Ficheros_txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContarCifras {
    public static void main(String[] args) {
        
        //*******PASARLE LOS ARGUMENTOS = ruta de la carpeta y ruta del archivo************
        String rutaCarpeta = args[0];
        String rutaArchivo = rutaCarpeta + File.separator + "sumarcantidades.txt";
        //*********************
        
        //INICIALIZAR PARA ESCRIBIR Y LEER******
        FileWriter fw = null;
        BufferedWriter bw = null;
        //*****************

        //**********************
        try {
            //*****************
            //Para la carpeta especificada
            File carpeta = new File(rutaCarpeta);
            //Obtiene la lista de archivos en la carpeta
            File[] archivosSuma = carpeta.listFiles();
            //********************

            //*************COMPROBAR QUE LA LISTA DE ARCHIVOS NO ESTÁ VACÍA********
            if (archivosSuma != null && archivosSuma.length > 0) {
                try {
                    bw = new BufferedWriter(new FileWriter(rutaArchivo));

                    //Itera sobre cada archivo en la carpeta
                    for (File archivo : archivosSuma) {
                        //Compureba si el elemento en la iteración es un archivo
                        if (archivo.isFile()) {
                            //Lee la cantidad sumada desde el archivo
                            int cantidad = leerCantidad(archivo);
                            //Cuenta las cifras de la cantidad leída
                            int cifras = contarCifras(cantidad);
                            bw.write(archivo.getName() + ": " + cifras + " cifras");
                            bw.newLine(); 
                        }
                    }
                    System.out.println("Conteo de cifras realizado correctamente. Resultados almacenados en " + rutaArchivo);
                } catch (IOException ex) {
                    Logger.getLogger(ContarCifras.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ContarCifras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                System.out.println("No se encontraron archivos de sumas en la carpeta especificada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //*****************************
    }

    //**********MÉTODO PARA LEER LA CANTIDAD SUMADA DESDE UN ARCHIVO**********
    private static int leerCantidad(File archivo) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine(); 
            return Integer.parseInt(linea);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(ContarCifras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //******************

    //**********MÉTODO PARA CONTAR LAS CIFRAS DE UN NÚMERO ENTERO********
    private static int contarCifras(int numero) {
        //Caso especial: si el número es 0, tiene una cifra
        if (numero == 0) {
            return 1;
        }

        int cifras = 0;
        //Divide repetidamente el número entre 10 y cuenta las divisiones hasta que sea 0
        while (numero != 0) {
            numero /= 10;
            cifras++;
        }
        return cifras; 
    }
    //******************
}
//**************
