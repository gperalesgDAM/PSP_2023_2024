package Ejem01_socket_TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

    public static void main(String[] args) throws IOException {

        int puerto = 6000;// Puerto 
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());

        Socket clientel = servidor.accept();//esperando a un cliente 
        //realizar acciones con clientel 
        System.out.println("Accion del cliente 1 finalizada");
        Socket cliente2 = servidor.accept();//esperando a otro cliente 
        System.out.println("Accion del cliente 2 finalizada");
        //realizar acciones con cliente2 

        servidor.close(); //cierro socket servidor

    }//fin de main

}//fin de SocketServidor
