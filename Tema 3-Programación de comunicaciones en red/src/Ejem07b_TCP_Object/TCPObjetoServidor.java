package Ejem07b_TCP_Object;

import java.io.*;
import java.net.*;

public class TCPObjetoServidor {

    public static void main(String[] args) throws Exception {

        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();

        // Se prepara un flujo de salida para objetos
        ObjectOutputStream outputObjeto = new ObjectOutputStream(cliente.getOutputStream());
        //Creamos un array de 5 objetos personas
        Persona[] personas = {
            new Persona("Juan", 20,false),
            new Persona("María", 25,false),
            new Persona("Pedro", 30,false),
            new Persona("Luisa", 22,false),
            new Persona("Carlos", 28, true),
        };

        // Enviamos cada persona al cliente
        for (Persona persona : personas) {
            outputObjeto.writeObject(persona);
            System.out.println("Envío: " + persona.getNombre() + ", " + persona.getEdad());
            outputObjeto.reset(); // Limpiamos el flujo para el siguiente objeto
        }

        outputObjeto.close();
        cliente.close();
        servidor.close();
    }

}
