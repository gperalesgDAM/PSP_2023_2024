package ejemplosProcessBuilder;

import java.io.IOException;
import java.io.InputStream;

public class E03a_Lanzar_DIR {
   public E03a_Lanzar_DIR() {
   }

   public static void main(String[] args) throws IOException {
      try {
         ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD", "/C", "DIR"});
         Process p = pb.start();
         InputStream is = p.getInputStream();

         int c;
         while((c = is.read()) != -1) {
            System.out.print((char)c);
         }

         is.close();
         int exitVal = p.waitFor();
         System.out.println("Valor de salida" + exitVal);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }
}
