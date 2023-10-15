/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E13_productor_consum_NO_Sin;

/**
 *
 * @author guipe
 */
public class ProductorConsumidor {
	public static void main(String[] args) throws InterruptedException {
		Monitor saf = new Monitor();
		Productor p = new Productor(saf);
		Consumidor c = new Consumidor(saf);
		Thread productor = new Thread(p);
		Thread consumidor = new Thread(c);
		productor.start();
		consumidor.start();
	}
}

