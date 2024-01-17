/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejem05_socket_UDP;

import java.net.*;

/**
 *
 * @author guipe
 */
public class ServidorUDP {

    public static void main(String[] args) {
        try {

            // 1. Crear un socket de datagrama en el puerto especificado
            int puertoServidor = 12346;
            DatagramSocket serverSocket = new DatagramSocket(puertoServidor);

            // Establecer el tiempo de espera en milisegundos para recibir paquetes
            int timeout = 10000; // 10 segundos
            serverSocket.setSoTimeout(timeout);

            while (true) {
                System.out.println("Servidor UDP esperando mensajes...");
                // 2. Preparar un DatagramPacket para recibir el mensaje del cliente
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                try {
                    // 3. Permanece a la espera de recibir datos del cliente
                    serverSocket.receive(paqueteRecibido);

                    // 4. Obtener los datos recibidos y la información sobre el cliente
                    String mensajeRecibido = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                    InetAddress direccionCliente = paqueteRecibido.getAddress();
                    int puertoCliente = paqueteRecibido.getPort();
                    System.out.println("Mensaje recibido del cliente " + direccionCliente + ":" + puertoCliente + ": " + mensajeRecibido);

                    // 5. Preparar la respuesta para enviar al cliente
                    String respuesta = "¡Hola, cliente!";
                    byte[] bufferSalida = respuesta.getBytes();

                    // 6. Crear un DatagramPacket con la respuesta y la información del cliente
                    DatagramPacket paqueteRespuesta = new DatagramPacket(bufferSalida, bufferSalida.length, direccionCliente, puertoCliente);

                    // 7. Enviar la respuesta al cliente con el método send
                    serverSocket.send(paqueteRespuesta);
                    System.out.println("Respuesta enviada al cliente.");
                } catch (SocketTimeoutException e) {
                    System.err.println("Tiempo de espera agotado para recibir paquetes.");
                    break;
                }
            }
            // 8. Cerrar el socket
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
