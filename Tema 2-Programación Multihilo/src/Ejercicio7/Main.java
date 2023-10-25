package Ejercicio7;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloTIC hTic = new HiloTIC();
                Thread hiloTic = new Thread(hTic);
		HiloTAC hTac = new HiloTAC();
                Thread hiloTac = new Thread(hTac);
		
		hiloTic.start();
		hiloTac.start();
	}

}
