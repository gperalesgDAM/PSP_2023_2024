package Ejercicio11;


class Contador {

  private int cuenta = 0;

  public int getCuenta() {
    return cuenta;
  }

  public int incrementa() {
    this.cuenta++;
    return cuenta;
  }

}

class Hilo implements Runnable {

  int numHilo, miParte, miCuenta = 0;
  private final Contador cont;

  public int getMiCuenta() {
    return miCuenta;
  }

  Hilo(int numHilo, int miParte, Contador c) {
    this.numHilo = numHilo;
    this.miParte = miParte;
    this.cont = c;
  }

  @Override
  public void run() {
    for (int i = 0; i < miParte; i++) {
      this.cont.incrementa();
      miCuenta++;
    }
    System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, getMiCuenta());
  }
}

class HilosCooperantesNoSincr {

    private static final int NUM_HILOS = 4;
    private static final int CUENTA_TOTAL = 100000;

    public static void main(String[] args) {

        Contador c = new Contador();
        Thread[] hilos = new Thread[NUM_HILOS];
        for (int i = 0; i < NUM_HILOS; i++) {
            Thread th = new Thread(new Hilo(i, CUENTA_TOTAL / NUM_HILOS, c));
            th.start();
            hilos[i] = th;

        }
        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
            }
        }
        System.out.printf("Cuenta global: %s\n", c.getCuenta());
    }

}
