package E07_estado_suspend;

class SolicitaSuspender {
	private boolean suspender;
	
	public synchronized void set (boolean b) {
		suspender = b;
		notifyAll();
	}
	
	public synchronized void esperandoParaReanudar () throws InterruptedException
	{
		while (suspender)
			wait(); //suspeder hilo hasta recibir notify
	}
}
