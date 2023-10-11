package ejemplosProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class E04a_Lanzar_DATE {
   public E04a_Lanzar_DATE() {
   }

   public static void main(String[] args) throws IOException {
      Process p = (new ProcessBuilder(new String[]{"CMD", "/C", "DATE"})).start();
      OutputStream os = p.getOutputStream();
      os.write("15-06-18".getBytes());
      os.flush();
      BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));

      for(String line = bf.readLine(); line != null; line = bf.readLine()) {
         System.out.println(line);
      }

      InputStream eis = p.getErrorStream();
      InputStreamReader eisr = new InputStreamReader(eis);
      BufferedReader ebr = new BufferedReader(eisr);

      String linea2;
      while((linea2 = ebr.readLine()) != null) {
         System.out.println(linea2);
      }

      eis.close();

      try {
         int exitVal = p.waitFor();
         System.out.println("valor de salida: " + exitVal);
      } catch (InterruptedException var11) {
         var11.printStackTrace();
      }

   }
}
