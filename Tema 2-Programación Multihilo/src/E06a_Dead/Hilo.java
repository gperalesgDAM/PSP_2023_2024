package E06a_Dead;

public class Hilo extends Thread {
	
	private boolean stopHilo = false;
	
	public void pararHilo() {
		stopHilo= true;
	}
	
	public void run() {
		while (!stopHilo) {
			System.out.println("En el Hilo");
		}
	}
	
	

}
