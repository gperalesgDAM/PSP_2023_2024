package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E09_Copiarfichero {
   public E09_Copiarfichero() {
   }

   public static void main(String[] args) throws IOException {
      File rutaOrigen = new File(".\\libros.txt");
      File rutaDestino = new File(".\\libroscopia.txt");
      FileInputStream fis = new FileInputStream(rutaOrigen);
      FileOutputStream fos = new FileOutputStream(rutaDestino);

      int b;
      while((b = fis.read()) != -1) {
         System.out.print((char)b);
         fos.write(b);
      }

      fis.close();
      fos.close();
   }
}
