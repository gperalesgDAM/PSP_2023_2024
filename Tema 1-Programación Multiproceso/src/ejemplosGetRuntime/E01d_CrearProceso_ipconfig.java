package ejemplosGetRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E01d_CrearProceso_ipconfig {
   public E01d_CrearProceso_ipconfig() {
   }

   public static void main(String[] args) {
      try {
         Process proceso = Runtime.getRuntime().exec("cmd.exe /C ipconfig");
         InputStreamReader inputStream = new InputStreamReader(proceso.getInputStream());
         BufferedReader reader = new BufferedReader(inputStream);

         String linea;
         while((linea = reader.readLine()) != null) {
            System.out.println(linea);
         }

         int exitCode = proceso.waitFor();
         System.out.println("Comando 'ipconfig' ejecutado con c\u00f3digo de salida: " + exitCode);
      } catch (InterruptedException | IOException var6) {
         var6.printStackTrace();
      }

   }
}
