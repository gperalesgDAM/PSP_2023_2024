package E_Basicos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMulticast {

	public static void main (String[] args) throws IOException {
	
	MulticastSocket ms = new MulticastSocket(12345);
	//Se configura la IP del grupo al que nos conectamos
	InetAddress grupo = InetAddress.getByName("225.0.0.1");
	//Se une al grupo
	ms.joinGroup(grupo);
	System.out.println("soy del grupo");
	//Recibe el paquete del servidor multicast
	byte[] buf = new byte[1000];
	DatagramPacket recibido = new DatagramPacket (buf, buf.length);
	ms.receive(recibido);
	System.out.println("recibo: " + recibido.getData());
	//abandona el grupo
	ms.leaveGroup(grupo);
	ms.close();
	}
}
