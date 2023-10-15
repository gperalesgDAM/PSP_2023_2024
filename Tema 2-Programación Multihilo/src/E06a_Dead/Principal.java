package E06a_Dead;

public class Principal {
	
	public static void main (String[] args) {
		Hilo h = new Hilo();
		h.start();
		for (int i=0;i<1000000;i++);//No hago nada
		h.pararHilo();
	}

}
