/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E13_productor_consum_NO_Sin;

/**
 *
 * @author guipe
 */
class Monitor {
	private int numero = 0;
	void Monitor(){
		numero=0;
	}
	
	public synchronized int coger() {
		return( numero );
	}
	
	public synchronized void dejar( int num ) {
		numero = num;
	}
}

