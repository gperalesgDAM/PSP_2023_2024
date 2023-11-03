/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

/**
 *
 * @author guipe
 */
public class Cuenta {
	
	private int saldo;
	
	Cuenta (int s) { 
		saldo = s; //inicializa el salda actual
	}
	
	 int getSaldo() {
		return saldo; //devuelve el saldo
	}
	
	 void restar (int cantidad) {
		saldo = saldo - cantidad;
	}
	
	 void retirarDinero (int cant, String nom) {
		
		if (getSaldo() >= cant) {
			
			System.out.println (nom + " : se va a retirar saldo,saldo actual: " + getSaldo());
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie ) { }
			
			restar (cant);
			System.out.println ("\t" + nom + " retira: " + cant 
                                        + " actual: " + getSaldo());
			
		} else {
			System.out.println ("No se puede retirar dinero,no hay saldo: " + getSaldo());
		}
		
		if (getSaldo() < 0) {
			System.out.println ("Saldo negativo: " + getSaldo());
		}	
	}
}

