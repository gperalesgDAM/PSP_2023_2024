package Ejem09_socket_hilos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = new Socket(host, puerto);

        //Se crean los flujos de entrada y salida
        //PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
        PrintWriter fsalida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, eco = "";
        do {
            System.out.println("Introduce cadena: ");
            cadena = in.readLine();
            fsalida.println(cadena);
            eco = fentrada.readLine();
            System.out.println("ECO: " + eco);
        } while (!cadena.trim().equals("*"));

        fsalida.close();
        fentrada.close();
        System.out.println("Fin del envio");
        in.close();
        cliente.close();
    }
}
