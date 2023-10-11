package ejemplosGetRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class E03c_Java_Version_buffered {
   public E03c_Java_Version_buffered() {
   }

   public static void main(String[] args) throws IOException {
      try {
         ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD", "/C", "java", "-version"});
         pb.redirectErrorStream(true);
         Process proceso = pb.start();
         InputStream is = proceso.getInputStream();
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(isr);
         String linea = "";

         while((linea = br.readLine()) != null) {
            System.out.println(linea);
         }

         is.close();
         int exitCode = proceso.waitFor();
         System.out.println("C\u00f3digo de salida: " + exitCode);
      } catch (InterruptedException | IOException var8) {
         var8.printStackTrace();
      }

   }
}
