package E03_Metodos;


public class Hilo extends Thread {
	
        @Override
	public void run() {
		
		System.out.println ("Dentro hilo: " + Thread.currentThread().getName());
		System.out.println ("Prioridad: " + Thread.currentThread().getPriority());
		System.out.println ("Id: " + Thread.currentThread().getId());
		System.out.println ("Hilos activos: " + Thread.currentThread().activeCount());
        }

}
