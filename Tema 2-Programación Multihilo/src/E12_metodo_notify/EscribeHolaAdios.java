package E12_metodo_notify;

class EscribeHolaAdios {
	boolean escritoHola = false;
	
	public synchronized void eAdios() {
		while (escritoHola == false) {
			try {
				wait();
				} catch (InterruptedException e) {
					
				}
			}
		escritoHola = false;
		System.out.println(" Adios ");
	}

	public synchronized void eHola() {
		System.out.println(" Hola ");
		escritoHola = true;
		notify();

	}		

}
