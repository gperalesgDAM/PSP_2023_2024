package Ejercicio7;


public class HiloTAC implements Runnable {

        @Override
	public void run(){
		while (true){
			System.out.println("TAC ");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fin de try-cathc
		}//fin de while
	}//fin de run
}//fin de clase HiloTIC