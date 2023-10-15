package E01_EjemploHilo1;

public class Principal {

	
	public static void main (String[] args) {
		
		Hilo h1 = new Hilo ("Hilo 1");
		Hilo h2 = new Hilo ("Hilo 2");
		Hilo h3 = new Hilo ("Hilo 3");
		
		h1.start();
		h2.start();
		h3.start();
	}
}
