package Ejercicio2;

public class HiloTAC extends Thread {

	public void run(){
		while (true){
			System.out.println("TAC ");
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fin de try-cathc
		}//fin de while
	}//fin de run
}//fin de clase HiloTIC