package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class E01_Lanzadorb {

    public void lanzarSumador(Integer n1, Integer n2, String fichResultado, String fichError, File carpeta) {
        String clase = "ejercicios.E01_Sumador";
        ProcessBuilder pb;
        try {
            String[] parametros = {"java", clase, n1.toString(), n2.toString()};
            pb = new ProcessBuilder(parametros);
            pb.directory(new File(".\\build\\classes"));
            //pb.directory(new File(path.toString()));
            pb.redirectError(new File(carpeta + fichError));
            pb.redirectOutput(new File(carpeta + fichResultado));
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getResultadoFichero(String nombreFichero, File carpeta) {
        int suma = 0;
        try {
            FileInputStream fichero = new FileInputStream(carpeta + nombreFichero);
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

    public static int introducirNumero(String texto) {
        boolean numCorrecto = false;
        int numero = 0;
        do {
            System.out.println(texto);
            Scanner lector = new Scanner(System.in);
            try {
                numero = lector.nextInt();
                numCorrecto = true;
            } catch (InputMismatchException e) {
                System.out.println("Los datos introducidos no son un número válido");
                numCorrecto = false;
            }
        } while (!numCorrecto);
        return numero;
    }
    public static String introducirFichero(String texto) {
        System.out.println(texto);
        Scanner lector = new Scanner(System.in);
        String fichero = "\\" + lector.nextLine() + ".txt";
        return fichero;
    }
    
    public static File introducirRuta() {
        boolean rutaCorrecta = true;
        //File carpeta = new File("");
        File carpeta;
        do {
            System.out.println("Introduce la ubicación donde almacenar los ficheros (pulsa intro para dejar ubicación del proyecto por defecto)");
            Scanner lector5 = new Scanner(System.in);
            String rutaName = lector5.nextLine();

            String ruta = "";
            // Determinar que no has introducido ningun nombre de ruta
//            if (rutaName==""){
//                System.out.println("No has introducido ningun nombre");
//            }
            if (rutaName.length() == 0) {
                ruta = ".\\archivos"; //Por defecto yo los guardo en esta carpeta
                //nombreCarpeta = ".";//Por defecto yo quisiera guardarlos en raiz del proyecto
                carpeta = new File(ruta);
            } else {
                ruta = rutaName;
                carpeta = new File(ruta);
            }
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {   //Crea el directorio nombrado por carpeta
                    System.out.println("La carpeta " + carpeta.getName() + " se ha creado correctamente");
                    rutaCorrecta = true;
                } else {
                    System.out.println("La carpeta " + carpeta.getName() + " no se ha podido crear");
                    rutaCorrecta = false;
                }
            } else {
                System.out.println("La carpeta " + carpeta.getName() + " ya existe");
                rutaCorrecta = true;
            }

        } while (!rutaCorrecta);
        return carpeta;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        E01_Lanzadorb l = new E01_Lanzadorb();

        int numero1 = introducirNumero("Introduce el primer número entero: ");
        int numero2 = introducirNumero("Introduce el segundo número entero: ");
        String fichero = introducirFichero("Introduce el nombre del fichero (sin extenxion):");
        String ficheroError = introducirFichero("Introduce el nombre del fichero de errores (sin extension):");
        File carpeta=introducirRuta();
        l.lanzarSumador(numero1, numero2, fichero, ficheroError, carpeta);
        Thread.sleep(1000);
        int sumaTotal = getResultadoFichero(fichero, carpeta);
        System.out.println("La suma total es:" + sumaTotal);

    }

}
