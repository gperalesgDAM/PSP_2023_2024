package Ejem11_socket_UDP_hilos;

import java.io.*;
import java.net.*;

public class ClienteUDP {

    public static void main(String args[]) throws Exception {

        //1. El cliente creará un socket para comunicarse con el servidor.
        DatagramSocket clientSocket = new DatagramSocket();//socket cliente
        // DATOS DEL SERVIDOR al que enviar mensaje
        InetAddress IPServidor = InetAddress.getLocalHost();// localhost 
        int puerto = 9876; // puerto por el que escucha 		

        // 2. Crear un mensaje para enviar al servidor introduciéndolo por teclado
        byte[] enviados = new byte[1024];
        // FLUJO PARA ENTRADA ESTANDAR POR TECLADO
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce mensaje: ");
        String cadena = in.readLine();
        enviados = cadena.getBytes();

        // 3. Crear un DatagramPacket(almacena el contenido del mensaje en un array de bytes) para enviar al servidor 
        System.out.println("Enviando " + enviados.length + " bytes al servidor.");
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);

        // 4. Enviar el paquete al servidor con el método send
        clientSocket.send(envio);

        // 5. Preparar un DatagramPacket para recibir la respuesta del servidor
        byte[] recibidos = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);

        // 6. Permanece a la espera de recibir datos del servidor
        System.out.println("Esperando datagrama....");
        clientSocket.receive(recibo);

        // 7. Obtener los datos recibidos y la información sobre el servidor
        String mayuscula = new String(recibo.getData());
        InetAddress IPOrigen = recibo.getAddress();
        int puertoOrigen = recibo.getPort();
        System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen);
        System.out.println("\tDatos: " + mayuscula.trim());

        //8. cerrar socket
        clientSocket.close();

    }//Fin de main

}//Fin de ClienteUDP
