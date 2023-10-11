package ejemplosGetRuntime;

public class E01a_CrearProceso_Notepad {
   public E01a_CrearProceso_Notepad() {
   }

   public static void main(String[] args) {
      try {
         String[] cmdArray = new String[]{"notepad.exe", "example.txt"};
         System.out.println("Ejecutando notepad.exe");
         Process process = Runtime.getRuntime().exec(cmdArray);
         System.out.println("Finalizado");
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}