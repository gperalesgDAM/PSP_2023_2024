package Ejercicio6;

public class Prioridades {

    public static void main(String args[]) {

        Hilo h1 = new Hilo();
        Hilo h2 = new Hilo();
        Hilo h3 = new Hilo();

        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        
        // Obtener el estado inicial del hilo
        Thread.State initialState = h1.getState();
        System.out.println("Estado inicial del hilo: " + initialState);
        
        h1.start();
        h2.start();
        h3.start();
        // Obtener el estado despues de arrancar el hilo
        Thread.State afterStart = h1.getState();
        System.out.println("Estado tras arrancar el hilo: " + afterStart);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura la bandera de interrupción
        }

        h1.interrupt();
        h2.interrupt();
        h3.interrupt();

        System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
        System.out.println("hl (Prioridad Normal): " + h1.getContador());
        System.out.println("h3 (Prioridad Minima): " + h3.getContador());

        System.out.println("hilos activos: " + Thread.activeCount());
        // Obtener el estado despues de interrumpir el hilo
        Thread.State afterinterrupt = h1.getState();
        System.out.println("Estado tras interrumpir el hilo: " + afterinterrupt);

    }
}
