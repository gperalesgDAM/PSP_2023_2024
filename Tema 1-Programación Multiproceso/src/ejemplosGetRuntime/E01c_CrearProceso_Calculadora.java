package ejemplosGetRuntime;

public class E01c_CrearProceso_Calculadora {
   public E01c_CrearProceso_Calculadora() {
   }

   public static void main(String[] args) {
      try {
         String[] parametros1 = new String[]{"CMD", "/C", "start calc"};
         String parametros2 = "CMD /C start calc";
         System.out.println("cal.exe");
         Process process = Runtime.getRuntime().exec(parametros1);
         process.waitFor();
         Thread.sleep(1000L);
         System.out.println("Finalizado primera calculadora");
         Process process2 = Runtime.getRuntime().exec(parametros2);
         process2.waitFor();
         System.out.println("Finalizado segunda calculadora");
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}