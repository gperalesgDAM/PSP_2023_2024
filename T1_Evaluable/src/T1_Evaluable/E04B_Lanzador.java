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
public class E04B_Lanzador {

    public static void main(String[] args) throws IOException  {
        File directorio = new File(".\\build\\classes");
        ProcessBuilder pb = new ProcessBuilder("java", "T1_Evaluable.E04B_Cadenas");

        pb.directory(directorio);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Process p = pb.start();
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(E04B_Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
