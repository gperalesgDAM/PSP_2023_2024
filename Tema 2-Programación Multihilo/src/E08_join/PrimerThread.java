package E08_join;

class PrimerThread extends Thread{
	public void run(){
		try {
			System.out.println("Hola soy un PrimerThread y acabo de arrancar");
			sleep(5000);
			System.out.println("Hola soy un PrimerThread y voy a terminar");
		} catch (InterruptedException e) {
		}
	}
}
