package Ejercicio11;


class Contador2 {

  private int cuenta = 0;

  public int getCuenta() {
    return cuenta;
  }

  synchronized public int incrementa() {
    this.cuenta++;
    return cuenta;
  }

}

class Hilo2 implements Runnable {

  int numHilo, miParte, miCuenta = 0;
  private final Contador2 cont;

  public int getMiCuenta() {
    return miCuenta;
  }

  Hilo2(int numHilo, int miParte, Contador2 c) {
    this.numHilo = numHilo;
    this.miParte = miParte;
    this.cont=c;
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

class HilosCooperantesSincr {

  private static final int NUM_HILOS = 4;
  private static final int CUENTA_TOTAL = 100000;

  public static void main(String[] args) {
    Contador2 c = new Contador2();
    Thread[] hilos = new Thread[NUM_HILOS];
    for (int i = 0; i < NUM_HILOS; i++) {
      Thread th = new Thread(new Hilo2(i, CUENTA_TOTAL / NUM_HILOS, c));
      th.start();
      hilos[i] = th;
    }
    for (Thread h: hilos) {
      try {
        h.join();
      } catch (InterruptedException e) {
      }
    }
    System.out.printf("Cuenta global: %s\n", c.getCuenta());
  }

}
