package ejemplosGetRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class E03c_Java_Version_getError {
   public E03c_Java_Version_getError() {
   }

   public static void main(String[] args) throws IOException {
      try {
         ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD", "/C", "javas", "-version"});
         Process proceso = pb.start();
         InputStream is = proceso.getInputStream();
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(isr);

         String linea;
         while((linea = br.readLine()) != null) {
            System.out.println(linea);
         }

         is.close();
         InputStream eis = proceso.getErrorStream();
         InputStreamReader eisr = new InputStreamReader(eis);
         BufferedReader ebr = new BufferedReader(eisr);

         String linea2;
         while((linea2 = ebr.readLine()) != null) {
            System.out.println(linea2);
         }

         eis.close();
         int exitCode = proceso.waitFor();
         System.out.println("C\u00f3digo de salida: " + exitCode);
      } catch (InterruptedException | IOException var12) {
         var12.printStackTrace();
      }

   }
}