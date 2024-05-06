package Orden_Ascendente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laura
 */
public class Restar {

    public static void main(String[] args) throws IOException {

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String ruta = args[2];

        num1--;
        num2--;

        //INICIALIZAR PARA ESCRIBIR Y LEER******
        FileWriter fw = null;
        BufferedWriter bw = null;
        //*****************

        //***************ESCRIBIR EN UN FICHERO***********
        try {
            //Escribir en un fichero esa frase
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            fw.write(num1);
            fw.write(num2);
            //Cerrar
            bw.close();
            fw.close();
            //Sacarlo por pantalla
            System.out.println("Número " + num1 + "se ha restado correctamente");
            System.out.println("Número " + num2 + "se ha restado correctamente");
            //**********************************************

        } catch (IOException ex) {
            Logger.getLogger(Restar.class.getName()).log(Level.SEVERE, null, ex);
        }
        //****************************

    }

}
