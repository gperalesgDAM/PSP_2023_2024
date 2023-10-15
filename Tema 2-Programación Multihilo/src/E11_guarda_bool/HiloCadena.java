package E11_guarda_bool;

public class HiloCadena extends Thread {
	
	private ObjetoCompartido objeto;
	String cad;
	
	public HiloCadena (ObjetoCompartido com, String cad) {
		this.objeto = com;
		this.cad = cad;	
	}
	
	public void run () {
		
		synchronized (objeto) {
			
			for (int j=0; j < 10; j++) {
				objeto.pintaCadena(cad);
				objeto.notify(); //aviso que ya he usado el objeto
				
				try { 
					objeto.wait(); //esperar a que llegue un notify
				} catch (InterruptedException ie) {}
			}
			objeto.notify(); //despertar todos los wait sobre el objeto
		}
			
	}

}
