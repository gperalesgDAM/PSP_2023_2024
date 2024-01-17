package Ejem08_UDP_Object;

import java.io.*;
import java.net.*;

public class UDPObjetoServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int puerto = 12345;

        DatagramSocket socket = new DatagramSocket(puerto);

        System.out.println("Esperando al cliente...");
        //Se realiza la recepción de un array de bytes que representan el objeto
        byte[] datosRecibidos = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
        socket.receive(paqueteRecibido); //recibo el datagra
        //convertimos el array de bytes en un stream de bytes
        ByteArrayInputStream bais = new ByteArrayInputStream(datosRecibidos);
        //convertimos el stream de bytes en un objeto de la clase general Object.
        ObjectInputStream entradaObjetos = new ObjectInputStream(bais);

        // Leer el objeto del cliente y lo convertimos a la clase Persona
        Persona persona = (Persona) entradaObjetos.readObject();
        System.out.println("Objeto recibido: " + persona.getNombre() + ", " + persona.getEdad());
        socket.close();

    }

}
