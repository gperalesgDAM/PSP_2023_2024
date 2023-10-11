package actividades;

public class A01_LanzarCalculadora {
   public A01_LanzarCalculadora() {
   }

   public static void main(String[] args) {
      String[] parametros = new String[]{"CMD", "/C", "start calc"};

      try {
         ProcessBuilder pb = new ProcessBuilder(parametros);
         pb.start();
         System.out.println("Finalizado");
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }
}
