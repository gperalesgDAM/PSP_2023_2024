package Ejem06_socket_UDP;

import java.net.*;

public class ServidorUDP {

    public static void main(String args[]) throws Exception {
        try {
            // 1. Crear un socket de datagrama en el puerto especificado
            DatagramSocket serverSocket = new DatagramSocket(9876);

            while (true) {
                System.out.println("Servidor UDP esperando mensajes...");

                // 2. Preparar un DatagramPacket para recibir el mensaje del cliente
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                // 3. Permanece a la espera de recibir datos del cliente
                serverSocket.receive(paqueteRecibido);

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

                // 7. Enviar la respuesta al cliente con el método send
                serverSocket.send(paqueteRespuesta);

                //Para terminar 
                if (mensajeRecibido.trim().equals("*")) {
                    break;
                }

            }//Fin de while

            serverSocket.close();
            System.out.println("Socket cerrado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Fin de main

}//Fin de ServidorUDP
