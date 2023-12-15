package T2_Evaluable;

class Consumidor implements Runnable {

    private Monitor bandeja;

    public Consumidor(Monitor s) {
        bandeja = s;
    }

    @Override
    public void run() {
        while (!(bandeja.isFinSecuencia() && bandeja.isColaVacia())) {
            bandeja.coger(Thread.currentThread().getName(), Thread.currentThread().getThreadGroup().getName());
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
            }
        }
    }
}
