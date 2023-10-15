package E05a_runnable;

public class Hilo implements Runnable {
	
	public void run() {
		System.out.println("Hola! desde el hilo: " + Thread.currentThread().getId());
	}

}
