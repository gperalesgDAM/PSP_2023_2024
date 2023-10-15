package E05a_runnable;

public class Principal {
	
	public static void main (String[] args) {
		//Primer hilo
		Hilo hilo1 = new Hilo();
		new Thread(hilo1).start();
		
		//Segundo hilo
		Hilo hilo2 = new Hilo();
		Thread hilo = new Thread(hilo2);
		hilo.start();
                
//  Se crea una instancia de la clase "Thread" y se la nombra como "hilo". 
//  Se pasa la instancia hilo2 como argumento al constructor de Thread. Esto significa que el hilo 
//  "hilo" se creará para ejecutar el código definido en la instancia "hilo2". "hilo2" debe ser una instancia de 
//  una clase que implementa la interfaz "Runnable", ya que se espera que proporcione la lógica que se ejecutará 
//  en el hilo.               
                
		
		//Tercer hilo
		new Thread (new Hilo()).start();
	}

}
