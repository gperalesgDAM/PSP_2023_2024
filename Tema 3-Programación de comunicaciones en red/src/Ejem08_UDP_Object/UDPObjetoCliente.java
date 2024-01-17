package Ejem08_UDP_Object;

import java.io.ByteArrayOutputStream;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPObjetoCliente {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 12345;

        DatagramSocket socket = new DatagramSocket();

        // Crear el objeto a enviar
        Persona persona = new Persona("Juan", 30);
     
        //Se crea un flujo de bytes de salida para almacenar en bytes objeto Persona.
        ByteArrayOutputStream salidaBytes = new ByteArrayOutputStream();
        ObjectOutputStream salidaObjetos = new ObjectOutputStream(salidaBytes);
        //En este punto, el objeto se ha convertido en una secuencia de bytes.
        salidaObjetos.writeObject(persona);
        //Se convierte el flujo de bytes en un array
        byte[] datosEnviados = salidaBytes.toByteArray();
        //Se realiza el envio mediante un DatagramPacket
        InetAddress direccion = InetAddress.getByName(host);
        DatagramPacket paqueteEnviado = new DatagramPacket(datosEnviados, datosEnviados.length, direccion, puerto);
        socket.send(paqueteEnviado);

        socket.close();
    }

}
