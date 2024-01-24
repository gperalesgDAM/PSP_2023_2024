package Ejem09_socket_hilos;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}
