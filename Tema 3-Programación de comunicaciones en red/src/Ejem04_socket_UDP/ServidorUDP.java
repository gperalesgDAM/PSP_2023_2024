/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejem04_socket_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author guipe
 */
public class ServidorUDP {

    public static void main(String[] args) throws Exception {

        //Asocio el socket al puerto 12345 por donde escuchará al cliente
        DatagramSocket socket = new DatagramSocket(12345);

        //Esperando datagrama
        System.out.println("Esperando datagrama...");

        //Creo el DatagramPacket donde recibiré los datos   
        byte[] bufer = new byte[1024]; //buffer para recibir el datagram
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo); //recibo datagrama
       
        //Utilizo metodos de DatagramPacket para trabajar con los datos recibidos
        int bytesRec = recibo.getLength(); // obtengo número de bytes
        String paquete = new String(recibo.getData()); //obtengo String

        //Visualizar información
        System.out.println("Número de bytes recibidos: " + bytesRec);
        System.out.println("Contenido del paquete: " + paquete.trim());
        //eliminar los espacios en blanco, tabulaciones, saltos de linea, etc al principio y al final de una cadena de caracteres
        System.out.println("Puerto origen del mensaje: "+ recibo.getPort());
        System.out.println("IP origen: "+ recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino " + recibo.getPort());

        socket.close();
    }
}

