package Ejem02_socket_TCP;


import java.io.*;
import java.net.*;

public class SocketServidor {

    public static void main(String[] arg) throws IOException {

        int puerto = 6000;// Puerto 
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Esperando al cliente en el puerto " + servidor.getLocalPort() + ".......");
        Socket cliente = servidor.accept();

        // CREO FLUJO DE ENTRADA DEL CLIENTE    
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        // EL CLIENTE ME ENVIA UN MENSAJE 
        System.out.println("Recibiendo del cliente: \n\t" + flujoEntrada.readUTF());

        // CREO FLUJO DE SALIDA AL CLIENTE 
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        // ENVIO UN SALUDO AL CLIENTE 
        flujoSalida.writeUTF("Saludos al cliente del servidor");
        // CERRAR STREAMS Y SOCKETS 

        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();

    }// main 

}// fin de Ejemplo1Servidor
