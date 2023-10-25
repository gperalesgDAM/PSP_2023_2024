package Ejercicio6;

class Hilo extends Thread {

    private int c = 0;

    public int getContador() {
        return c;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            c++;

        }

    }
}
