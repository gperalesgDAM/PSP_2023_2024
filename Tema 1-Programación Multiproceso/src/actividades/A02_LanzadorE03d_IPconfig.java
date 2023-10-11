package actividades;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class A02_LanzadorE03d_IPconfig {
   public A02_LanzadorE03d_IPconfig() {
   }

   public static void main(String[] args) throws IOException {
      File directorio = new File(".\\build\\classes");
      ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "ejemplosProcessBuilder.E03d_IPconfig"});
      pb.directory(directorio);
      Process p = pb.start();
      InputStream is = p.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      String linea;
      while((linea = br.readLine()) != null) {
         System.out.println(linea);
      }

      is.close();
   }
}