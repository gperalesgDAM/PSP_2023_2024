/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class E01b_InetClass {
	private static final String HEADER 
= "**********************************************************";

	public static void main(String[] args) {
		// acceder a localhost
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(HEADER);
			System.out.println("getLocalHost : " + local);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Mostrar información de distintas máquinas
		// accediendo por su nombre
		InetAddress ip = null;
		try {
			System.out.println(HEADER);
			// obtener la ip a través del nombre
			ip = InetAddress.getByName("localhost");
			test(ip);
			System.out.println(HEADER);
			// obtener la ip a través del nombre
			ip = InetAddress.getByName("www.google.es");
			test(ip);
			System.out.println(HEADER);
			// obtener la ip a través del nombre
			ip = InetAddress.getByName("www.elpais.com");
			test(ip);
			System.out.println(HEADER);
			// obtener la ip a través del nombre
			ip = InetAddress.getByName("www.heraldo.es");
			test(ip);
			System.out.println(HEADER);

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}

	private static void test(InetAddress ip) {
		// Mostrar la información que devuelven algunos de los métodos de la clase
		System.out.println("\t getByName: " + ip);
		System.out.println("\t getHostName: " + ip.getHostName());
		System.out.println("\t getHostAddress: " + ip.getHostAddress());
		System.out.println("\t getCanonicalHostName: " + ip.getCanonicalHostName());
		try {
			// obtener todas las IPs asociadas a un nombre
			InetAddress[] ips = InetAddress.getAllByName(ip.getHostName());
			System.out.println("\t direcciones para " + ip.getHostName() + ":");
			for (int i = 0; i < ips.length; i++) {
				System.out.println("\t\t " + ips[i]);
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}
}

