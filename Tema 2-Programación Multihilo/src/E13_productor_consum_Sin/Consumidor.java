package E13_productor_consum_Sin;

class Consumidor implements Runnable {
	private Monitor bandeja;
	public Consumidor( Monitor s ) {
		bandeja = s;
	}

	public void run() {
		int num;
		for( int i=0; i < 5; i++ ){
			num = bandeja.coger();
			System.out.println( "Número cogido: "+num );
			try {
				Thread.sleep( (int)(Math.random() * 2000 ) );
			} catch( InterruptedException e ) {;}
		}
	}
}
