package Orden_Ascendente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laura
 */
public class Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {

        //*****************INGRESAR EL TEXTO A ANALIZAR********************
        Scanner scanner = new Scanner(System.in);
        File directorio = new File(".\\build\\classes");
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();
        scanner.close();
        //***************************

        //**********CONTROLAR QUE TODOS LOS PROCESO HAN FINALIZADO --> EN ESTE CASO ES EL DE LA CLASE ASCENDENTE*************
        //Crear un Array de procesos = llamarlo cuando haces el start() y en el wait()
        Process[] procesosAscendentes = new Process[5];
        //****************************************

        //**********CREAR 5 PROCESOS
        for (int numProceso = 0; numProceso < 5; numProceso++) {

        //******************

        //****************PASAR LOS ARGUMENTOS AL PROCESO HIJO*******************
        //Ubicarnos en el directorio y con el ProcessBuilder pasarle los argumentos --> número del proceso, vocal, texto
        ProcessBuilder pb = new ProcessBuilder("java", "Orden_Ascendente.Ascendente", String.valueOf(numProceso), String.valueOf(num1), String.valueOf(num2));
        //Pasarle la dirección del directorio
        pb.directory(directorio);
        //Habilitar la entrada y salida para comunicar el padre con el hijo
        pb.inheritIO();
        //Comenzar el proceso hijo
        procesosAscendentes[numProceso] = pb.start();
        //****************************
    }


    //*************ESPERAR A QUE TODOS LOS PROCESOS SE COMPLETEN************
    for (Process proceso : procesosAscendentes) {
            try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //*************************************************

    //************CREAR UNA NUEVA CARPETA Y EN LA UBICACIÓN QUE ME DICEN --> EN ESTE CASO ES EL DE CLASE ASCENDENTE*************
    //user.dir = ubicación que estoy ahora mismo
    String rutaCarpeta = System.getProperty("user.dir") + "//Archivos"; //Nombre de la carpeta
    String ruta = rutaCarpeta + "\\ascendente.txt"; //Ruta con nombre del fichero
    //**************************

    //************CREAR NUEVA CARPETA Y PASARLE LOS ARGUMENTOS --> EN ESTE CASO ES EL DE CLASE ASCENDENTE************
    if (nuevaCarpeta(rutaCarpeta)) {
        // Ubicarnos en el directorio y con el ProcessBuilder pasarle los argumentos --> num1, num2, ruta
        ProcessBuilder pb = new ProcessBuilder("java", "Orden_Ascendente.Restar", String.valueOf(num1), String.valueOf(num2), ruta);
        pb.directory(directorio);
        pb.inheritIO();
        Process procesoResta;
        try {
            procesoResta = pb.start();
            procesoResta.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Lanzador lanzador = new Lanzador();
        String textoMay = lanzador.getResultadoFichero(ruta);
        System.out.println("El texto escrito en el archivo es: " + textoMay);
    }else {
            System.out.println("Existe algún problema con la ruta de la carpeta");
    }
    }
    //***************MÉTODO TODO PARA CREAR NUEVAS CARPETAS Y VER SI EXISTEN O NO. SI NO HAY CREARLA*************
    public static Boolean nuevaCarpeta(String ruta) {
        File carpeta = new File(ruta);

        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("La carpeta " + carpeta.getName() + " se ha creado correctamente");
                return true;
            } else {
                System.out.println("La carpeta " + carpeta.getName() + " no se ha podido crear");
                return false;
            }
        } else {
            System.out.println("La arpeta " + carpeta.getName() + " ya existe");
            return true;
        }
    }
    //*******************

    //*******MÉTODO PARA SACAR EL RESULTADO FINAL**************
    public String getResultadoFichero(String ruta) {
        String linea = "";
        BufferedReader br = null; //Declarar BufferedReader fuera del try para que sea accesible en el bloque finally

        try {
            FileReader fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            //Leer el archivo línea a línea
            StringBuilder resultado = new StringBuilder(); //Utilizar StringBuilder para construir el resultado
            while ((linea = br.readLine()) != null) {
                resultado.append(linea).append("\n"); //Agregar la línea al resultado
            }
            return resultado.toString(); //Devolver el resultado al finalizar la lectura del archivo

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex); //Cambiar el nombre de la clase aquí
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ""; //En caso de error, devolver una cadena vacía
    }
    //**********************

}
