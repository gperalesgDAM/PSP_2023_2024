/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E04_Grupo;

/**
 *
 * @author guipe
 */
public class Junto extends Thread {
	public void run() {
		System.out.println ("Hilo: " +
                                Thread.currentThread().toString());
	}
	public static void main (String[] args) {
		Thread.currentThread().setName("Principal");
		System.out.println (Thread.currentThread().getName());
		System.out.println (Thread.currentThread().toString());
		ThreadGroup grupo = new ThreadGroup ("grupos de hilos");
		Junto h = new Junto ();
		Thread h1 = new Thread(grupo, h, "Hilo 1");
		Thread h2 = new Thread(grupo, h, "Hilo 2");
		Thread h3 = new Thread(grupo, h, "Hilo 3");
		h1.start();
		h2.start();
		h3.start();
		System.out.println ("3 hilos creados");
		System.out.println ("hilos activos: " + Thread.activeCount());
	}
}

