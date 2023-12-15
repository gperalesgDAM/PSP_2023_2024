/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T1_Evaluable;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guipe
 */
public class E04A_Lanzador {

    public static void main(String[] args) throws IOException  {
        File directorio = new File(".\\build\\classes");
        ProcessBuilder pb = new ProcessBuilder("java", "T1_Evaluable.E04A_Cadenas");

        pb.directory(directorio);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Process p = pb.start();
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(E04A_Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
