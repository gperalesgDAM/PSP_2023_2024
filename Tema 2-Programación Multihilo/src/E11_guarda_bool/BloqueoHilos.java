package E11_guarda_bool;

public class BloqueoHilos {
	
	
	
	public static void main (String[] args) {
		
		ObjetoCompartido com = new ObjetoCompartido();
		HiloCadena a = new HiloCadena(com, "Hola");
		HiloCadena b = new HiloCadena(com, "Adios");
		a.start();
		b.start();
	}

}
