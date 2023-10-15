package E06b_DeadInterrupted;

public class EjemploHiloDeadInterrupted extends Thread {

    int c = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("En el Hilo");
            c++;
        }
    }

    public static void main(String[] args) {
        EjemploHiloDeadInterrupted h = new EjemploHiloDeadInterrupted();
        h.setName("hilo1");
        h.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        for (int i = 0; i < 1000000; i++);//No hago nada
        h.interrupt();
    }

}
