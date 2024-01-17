package Ejem01_socket_TCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketCliente {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int puerto = 6000;//puerto remoto 

        // ABRIR SOCKET 
        System.out.println("Programa cliente iniciado....");
        Socket cliente = new Socket(host, puerto);//conectar 

        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("Puerto Remoto: " + cliente.getPort());
        InetAddress i = cliente.getInetAddress();
        System.out.println("Host/IP: " + i);
        System.out.println("Host Remoto: " + i.getHostName());
        System.out.println("IP Host Remoto: " + i.getHostAddress());

        cliente.close();// Cierra el socket

    }//fin de main

}//fin de SocketCliente
