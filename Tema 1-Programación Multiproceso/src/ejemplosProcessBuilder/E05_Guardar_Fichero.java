// Source code is decompiled from a .class file using FernFlower decompiler.
package ejemplosProcessBuilder;

import java.io.File;
import java.io.IOException;

public class E05_Guardar_Fichero {
   public E05_Guardar_Fichero() {
   }

   public static void main(String[] args) throws IOException {
      ProcessBuilder pb = new ProcessBuilder(new String[]{"CMD", "/C", "DIRR"});
      File directorio = new File(".\\build\\classes");
      File fOut = new File("salida.txt");
      File fErr = new File("error.txt");
      pb.redirectOutput(fOut);
      pb.redirectError(fErr);
      File directorio2 = new File(".\\archivos");
      pb.start();
      System.out.println(directorio.getAbsolutePath());
      System.out.println(directorio2.getAbsolutePath());
   }
}
