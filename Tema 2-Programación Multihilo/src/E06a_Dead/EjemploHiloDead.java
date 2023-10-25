package E06a_Dead;


public class EjemploHiloDead extends Thread {

    private boolean stopHilo = false;
    int c = 0;

    public void pararHilo() {
        stopHilo = true;
    }

    @Override
    public void run() {
        while (!stopHilo) {
          //  System.out.println("En el Hilo");
            c++;
        }
    }

    public static void main(String[] args) {
        EjemploHiloDead h = new EjemploHiloDead();
        h.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        for (int i = 0; i < 1000000; i++);//No hago nada
        h.pararHilo();
    }

}
