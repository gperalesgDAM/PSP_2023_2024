package T2_Evaluable;

import java.util.Random;

class Productor implements Runnable {

    private Monitor bandeja;

    public Productor(Monitor s) {
        bandeja = s;
    }

    private int numero = 0;

    @Override
    public void run() {
        Random random = new Random();
        while (!bandeja.isFinSecuencia()) {
            //   synchronized (bandeja) {
            do {
                synchronized (bandeja) {
                    numero = random.nextInt(50);
                }
            } while (bandeja.comprobarLista(numero));
            bandeja.dejar(numero, Thread.currentThread().getName(), Thread.currentThread().getThreadGroup().getName());

            //   }
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
