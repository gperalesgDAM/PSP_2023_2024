package E08_join;

public class Principal {
	
	public static void main(String args[]) {
		try {
			//Crea un objeto de la clase PrimerThread
			Thread t = new PrimerThread();
			t.start();
			System.out.println("Hola soy el thread principal");
			System.out.println("He puesto en marcha un proceso");
                        t.join();//Este m�todo espera a que el hilo de ejecuci�n t, termine 
			//t.join(2000);//Este m�todo espera a que el hilo de ejecuci�n t, termine 
			System.out.println("Fin del join");
		} catch (Exception e) {
			
		}
	}
}


