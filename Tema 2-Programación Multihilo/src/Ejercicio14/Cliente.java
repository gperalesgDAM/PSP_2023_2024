package Ejercicio14;

import java.util.Random;

class Cliente extends Thread {
	private int id;
	private Caja caja;
	
	private static final int MAX_DELAY = 6000;
	private static final int MAX_COST = 100;

	Cliente (int id, Caja caja) {
		 this.id = id;
		 this.caja = caja;
	 }
	
	public int getIdCliente() {
		return id;
	}
	
        @Override
	public void run() {
		
		try{     
			long t = new Random().nextInt(MAX_DELAY); //Tiempo que le cuesta realizar la compra a cada cliente
			//System.out.println("Cliente " + id + " realizando compra en caja: " + caja.getIdCaja() +  ", tiempo estimado: " + t/1000);
			Thread.sleep(t);
			long s = System.currentTimeMillis(); //Tiempo Unix en ms desde 1970
			caja.esperar(this);     
			caja.imprimir();
			caja.atender(new Random().nextInt(MAX_COST));     
			//System.out.println("Cliente " + id +  " atendido");
			long espera = System.currentTimeMillis() - s;
			synchronized(Resultados.class){
                        Resultados.tiempoEspera += espera;  
                        }
			//System.out.println("Cliente " + id + " saliendo después de esperar " + espera);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
