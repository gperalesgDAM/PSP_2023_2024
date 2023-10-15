package E07_estado_suspend;

public class EjemploSuspend extends Thread {

	private SolicitaSuspender ss = new SolicitaSuspender();
	
	public void suspender() {
		ss.set(true);
	}
	
	public void reanudar() {
		ss.set(false);
	}
	
	public void run () {
		try {
			
			while (true) {
				ss.esperandoParaReanudar();
			}
			
		} catch (InterruptedException ie) {}
		
	}
	
}


