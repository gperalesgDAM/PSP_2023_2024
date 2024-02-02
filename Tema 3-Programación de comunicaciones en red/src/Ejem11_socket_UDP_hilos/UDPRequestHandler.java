/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejem11_socket_UDP_hilos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author guipe
 */
class UDPRequestHandler implements Runnable {

    private DatagramSocket serverSocket;
    private DatagramPacket paqueteRecibido;

    public UDPRequestHandler(DatagramSocket serverSocket, DatagramPacket paqueteRecibido) {
        this.serverSocket = serverSocket;
        this.paqueteRecibido = paqueteRecibido;
    }

    @Override
    public void run() {
        try {
            // Procesar la solicitud aquí (puedes acceder a los datos a través de packet.getData())

            // 4. Obtener los datos recibidos y la información sobre el cliente
            String mensajeRecibido = new String(paqueteRecibido.getData());
            InetAddress direccionCliente = paqueteRecibido.getAddress();
            int puertoCliente = paqueteRecibido.getPort();
            System.out.println("Mensaje recibido del cliente " + direccionCliente + ":" + puertoCliente + ": " + mensajeRecibido);
            // 5. Preparar la respuesta para enviar al cliente
            //CONVERTIR CADENA A MAYÚSCULA 
            String mayusculas = mensajeRecibido.trim().toUpperCase();
            byte[] bufferSalida = mayusculas.getBytes();

            // 6. Crear un DatagramPacket con la respuesta y la información del cliente
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferSalida, bufferSalida.length, direccionCliente, puertoCliente);
            serverSocket.send(paqueteRespuesta);
           // serverSocket.close();
            System.out.println("Socket cerrado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
