/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejem04_socket_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author guipe
 */
public class ClienteUDP {

    public static void main(String[] args) throws Exception {

        // Crear un socket de datagrama
        DatagramSocket socket = new DatagramSocket(34567);

        //Definir dirección y puerto al que envío el datagrama
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;

        // Crear un mensaje para enviar al servidor
        String saludo = "         Enviando saludos!!!      ";
        byte[] mensaje = saludo.getBytes();

        //Construyo el datagrama a enviar al servidor
        DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length, destino, port);
        System.out.println("Enviando datagrama de longitud: " + mensaje.length);
        System.out.println("Host destino: " + destino.getHostName());
        System.out.println("IP destino: " + destino.getHostAddress());
        System.out.println("Puerto local del socket: "+ socket.getLocalPort());
        System.out.println("Puerto de envío " + envio.getPort());
        // Enviar el paquete al servidor
        socket.send(envio);
        // Cerrar el socket
        socket.close();
    }
}
