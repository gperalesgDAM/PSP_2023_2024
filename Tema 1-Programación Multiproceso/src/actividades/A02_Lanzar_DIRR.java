/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividades;

import java.io.IOException;
import java.io.InputStream;

public class A02_Lanzar_DIRR {
   public A02_Lanzar_DIRR() {
   }

   public static void main(String[] args) throws IOException {
      try {
         ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD", "/C", "DIR"});
         Process p = pb.start();
         InputStream is = p.getInputStream();
         pb.redirectErrorStream(true);

         int c;
         while((c = is.read()) != -1) {
            System.out.print((char)c);
         }

         is.close();
         InputStream errorStream = p.getErrorStream();

         while((c = errorStream.read()) != -1) {
            System.err.print((char)c);
         }

         errorStream.close();
         int exitVal = p.waitFor();
         System.out.println("\nValor de salida: " + exitVal);
      } catch (Exception var7) {
         var7.printStackTrace();
      }

   }
}
