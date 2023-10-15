package E09c_Ester_ContadorNoSinc;

public class HiloA extends Thread {
		
		private Contador contador; 
		
		public HiloA(String n, Contador c) { 
			
			setName(n); 
			contador = c; 
		} 
		
		public void run() {    
			
			for (int j = 0; j < 300; j++) { 
				contador.incrementa(); //incrementa el contador 
				try { 
					sleep(10); 
				} catch (InterruptedException e) {} 
			}
			System.out.println(getName() + " contador vale " + contador.getValor()); 
		} 
}// Fin de HiloA 
		