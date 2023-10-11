package actividades;

public class A01_LanzarCalculadoras {
   public A01_LanzarCalculadoras() {
   }

   public static void main(String[] args) {
      String[] parametros = new String[]{"CMD", "/C", "start calc"};
      ProcessBuilder[] pb = new ProcessBuilder[10];
      Process[] p = new Process[10];

      try {
         for(int i = 0; i < 10; ++i) {
            pb[i] = new ProcessBuilder(parametros);
            p[i] = pb[i].start();
            Thread.sleep(1000L);
         }

         System.out.println("Finalizado");
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}