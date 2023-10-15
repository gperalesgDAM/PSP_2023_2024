package E12_metodo_notify;

class E_Adios implements Runnable {
	EscribeHolaAdios eh;
	E_Adios (EscribeHolaAdios eh) {
		this.eh = eh;
		new Thread(this, "Adios").start();
	}
	
	public void run() {
		for(int x=0;x<5;x++) {
			eh.eAdios();
		}
	}
}
