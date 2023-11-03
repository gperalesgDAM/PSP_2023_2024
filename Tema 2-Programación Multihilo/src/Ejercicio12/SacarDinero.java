/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

/**
 *
 * @author guipe
 */
public class SacarDinero extends Thread {
	
	private Cuenta c;
	String nom;
	
	public SacarDinero (String n, Cuenta c) {
		super (n);
		this.c=c;
	}
	
        @Override
	public void run() {
		for (int x=1; x<=4; x++) {
			c.retirarDinero(10, getName());
		}
	}

}

