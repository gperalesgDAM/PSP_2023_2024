package E12_metodo_notify;

class E_Hola implements Runnable {
	EscribeHolaAdios eh;
	E_Hola (EscribeHolaAdios eh) {
		this.eh = eh;
		new Thread(this, "Hola").start();
	}
	
	public void run() {
		try{
			for(int x=0;x<5;x++) {
				Thread.sleep(1000);
				eh.eHola();
			}
		}catch (InterruptedException e){
			
		}
	}
}
