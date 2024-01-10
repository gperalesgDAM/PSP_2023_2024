/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejem03_socket_TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author guipe
 */
public class SocketServidor {

    public static void main(String[] args) throws IOException {

        int puerto = 44440;//puerto remoto 
        // Establece el puerto en el que escucha peticiones
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(puerto);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + puerto);
            System.exit(-1);
        }

        Socket cliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        System.out.println("Escuchando: " + servidor.toString());
        try {
            // Se bloquea hasta que recibe alguna petición de un cliente
            // abriendo un socket para el cliente
            cliente = servidor.accept();
            System.out.println("Conexión aceptada: " + cliente);
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);

            // Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
            while (true) {
                // Recibe la solicitud del cliente por el InputStream
                String str = entrada.readLine();
                // Envía a la salida estándar el mensaje del cliente
                System.out.println("Cliente: " + str);
                // Le envía la respuesta al cliente por el OutputStream                
                salida.println(str);
                // Si es "Adios" es que finaliza la comunicación
                if (str.equals("Adios")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        salida.close();
        entrada.close();
        cliente.close();
        servidor.close();
    }

}
