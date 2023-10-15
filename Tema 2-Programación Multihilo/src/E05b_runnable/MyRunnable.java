package E05b_runnable;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Dentro del método run, puedes obtener el nombre del hilo actual
        String threadName = Thread.currentThread().getName();
        System.out.println("Nombre del hilo: " + threadName);
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        // Crear un objeto Thread pasando el Runnable
        Thread thread = new Thread(myRunnable, "NombrePersonal");

        // Iniciar el hilo
        thread.start();
    }
}





