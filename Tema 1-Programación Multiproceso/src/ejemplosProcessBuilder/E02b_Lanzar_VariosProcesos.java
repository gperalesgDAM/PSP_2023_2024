package ejemplosProcessBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E02b_Lanzar_VariosProcesos {
   public E02b_Lanzar_VariosProcesos() {
   }

   public static void main(String[] args) throws Exception {
      String[] ruta = new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
      ProcessBuilder pb1 = new ProcessBuilder(new String[]{"NOTEPAD"});
      ProcessBuilder pb2 = new ProcessBuilder(new String[]{"CALC"});
      ProcessBuilder pb3 = new ProcessBuilder(new String[]{"CMD", "/K", "start"});
      ProcessBuilder pb4 = new ProcessBuilder(ruta);
      ProcessBuilder pb5 = new ProcessBuilder(new String[]{"CMD", "/K", "ipconfig"});
      Process p1 = pb1.start();
      Process p2 = pb2.start();
      Process p3 = pb3.start();
      Process p4 = pb4.start();
      Process p5 = pb5.start();
      BufferedReader bf = new BufferedReader(new InputStreamReader(p5.getInputStream()));

      for(String line = bf.readLine(); line != null; line = bf.readLine()) {
         System.out.println(line);
      }

   }
}