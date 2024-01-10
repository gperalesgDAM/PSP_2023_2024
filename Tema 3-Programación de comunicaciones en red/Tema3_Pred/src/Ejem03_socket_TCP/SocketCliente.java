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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author guipe
 */
public class SocketCliente {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = null;
        PrintWriter salida = null;
        Socket cliente =null;
        String host = "localhost";
        int puerto = 44440;//puerto remoto 

        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que está en la misma máquina que el cliente
        // y que escucha en el puerto 44440
        try {
            cliente = new Socket(host, puerto);
            // Obtenemos el canal de entrada
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            // Obtenemos el canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
            //autoFlush: el búfer se vaciará automáticamente después de cada operación de escritura
        } catch (IOException e) {
            System.err.println("No puede establecer canales de E/S para la conexión");
            System.exit(-1);
        }
        Scanner stdIn = new Scanner(System.in);

        String linea;

        // El programa cliente no analiza los mensajes enviados por el
        // usuario, simplemente los reenvía al servidor hasta que este
        // se despide con "Adios"
        try {
            while (true) {
                System.out.println("Escriba un mensaje para enviar al servidor: ");
                // Leo la entrada del usuario
                linea = stdIn.nextLine();
                // La envia al servidor por el OutputStream
                salida.println(linea);
                // Recibe la respuesta del servidor por el InputStream
                linea = entrada.readLine();
                // Envía a la salida estándar la respuesta del servidor
                System.out.println("Respuesta servidor: " + linea);
                // Si es "Adios" es que finaliza la comunicación
                if (linea.equals("Adios")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Libera recursos
        salida.close();
        entrada.close();
        stdIn.close();
        cliente.close();
    }
}