package Ejem07_TCP_Object;

import java.io.*;
import java.net.*;

public class TCPObjetoServidor {

    public static void main(String[] args) throws Exception {

        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();

        // Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

        // Se prepara el objeto y se envía
        Persona per = new Persona("Juan", 20);
        outObjeto.writeObject(per);
        System.out.println("Envio " + per.getNombre() + "*" + per.getEdad());

        outObjeto.close();
        cliente.close();
        servidor.close();
    }

}
