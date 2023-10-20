package Ejercicio3;


public class Hilo extends Thread {
	private int c;	//contador de cada hilo
	private int hilo;
	
	//Constructor
	public Hilo(int hilo){
		this.hilo = hilo;
		System.out.println("CREANDO HILO: " + hilo);
	}
	
	//Método run
        @Override
	public void run(){
		c = 0;
		while ( c<=10 ){
			System.out.println("Hilo" + hilo + " C = " + c);
			c++;
		}
	}//fin de run
	

	
}//fin clase Hilo
