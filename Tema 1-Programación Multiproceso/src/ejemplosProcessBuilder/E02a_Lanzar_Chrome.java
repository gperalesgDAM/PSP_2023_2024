package ejemplosProcessBuilder;

public class E02a_Lanzar_Chrome {
   public E02a_Lanzar_Chrome() {
   }

   public static void main(String[] args) {
      String[] ruta = new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};

      try {
         ProcessBuilder pb = new ProcessBuilder(ruta);
         Process var3 = pb.start();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }
}
