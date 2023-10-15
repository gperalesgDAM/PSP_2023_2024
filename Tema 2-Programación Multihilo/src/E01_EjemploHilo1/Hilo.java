package E01_EjemploHilo1;

public class Hilo extends Thread {

	Hilo (String nombre) {
		super (nombre);
		System.out.println ("creando hilo: " + getName());
	}
	
        @Override
	public void run() {
		
		for (int i=0; i<5; i++)
			System.out.println("Hilo: " + getName() + " c: " + i);
	}
}
