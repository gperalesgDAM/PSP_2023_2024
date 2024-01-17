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

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            //1. El cliente creará un socket para comunicarse con el servidor.
            DatagramSocket socket = new DatagramSocket();

            // Definir la dirección IP y el puerto del servidor al que se enviará el mensaje
            InetAddress servidorDireccion = InetAddress.getByName("127.0.0.1"); // Cambia a la dirección del servidor
            int servidorPuerto = 12346; // Cambia al puerto del servidor

            // 2. Crear un mensaje para enviar al servidor
            String saludo = "¡Hola, servidor!";
            byte[] mensaje = saludo.getBytes();

            // 3. Crear un DatagramPacket(almacena el contenido del mensaje en un array de bytes) para enviar al servidor 
            DatagramPacket paqueteEnviar = new DatagramPacket(mensaje, mensaje.length, servidorDireccion, servidorPuerto);

            // 4. Enviar el paquete al servidor con el método send
            socket.send(paqueteEnviar);

            // 5. Preparar un DatagramPacket para recibir la respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibir = new DatagramPacket(buffer, buffer.length);

            // 6. Permanece a la espera de recibir datos del servidor
            socket.receive(paqueteRecibir);

            // 7. Obtener los datos recibidos y la información sobre el servidor
            String respuesta = new String(paqueteRecibir.getData(), 0, paqueteRecibir.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

            // 8. Cerrar el socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
