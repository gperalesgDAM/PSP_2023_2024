/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E13_productor_consum_NO_Sin;

/**
 *
 * @author guipe
 */
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

