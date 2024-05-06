package Ficheros_txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SumarCantidades {

    public static void main(String[] args) {

        
        //*******PASARLE LOS ARGUMENTOS = numProceso y nombre del fichero************
        int numProceso = Integer.parseInt(args[0]);
        String nombreFichero = args[1];
        //******************
        //********INICIALIZAR PARA ESCRIBIR Y LEER****
        FileWriter fw = null;
        BufferedWriter bw = null;
        //**************

        try {
            //***************
            //Para escribir en el archivo
            fw = new FileWriter(nombreFichero);
            bw = new BufferedWriter(fw);
            //***********************

            //*******************
            //Cerrar todo
            bw.close();
            fw.close();
            //*************

            System.out.println("El proceso " + numProceso + " ha sumado un total de [SUMA_TOTAL]");
        } catch (IOException ex) {
            Logger.getLogger(SumarCantidades.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SumarCantidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}