package Ejem09_socket_hilos;

import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {

    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;

    public HiloServidor(Socket socket) {
        try {
            this.socket = socket;
            // se crean flujos de entrada y salida con el cliente
            //fsalida = new PrintWriter(socket.getOutputStream(), true);
            // estás configurando la instancia para que realice la operación de vaciado
            //automático del búfer después de cada operación de escritura
            fsalida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("No puede establecer canales de E/S para la conexión");
            System.exit(-1);
        }

    }

    @Override
    public void run() {
        try {

            //tarea a realizar con el cliente
            String cadena = "";
            System.out.println("Comunico con: " + socket.toString());

            while (!cadena.trim().equals("*")) {
                cadena = fentrada.readLine();
                fsalida.println(cadena.trim().toUpperCase());
                System.out.println("Envio a: " + socket.toString() + " la cadena " + cadena.trim().toUpperCase());
            }

            System.out.println("Fin con: " + socket.toString());
            fsalida.close();
            fentrada.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
