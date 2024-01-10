package Ejem02_socket_TCP;

import java.io.*;
import java.net.*;

public class SocketCliente {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int puerto = 6000;//puerto remoto 

        // ABRIR SOCKET 
        System.out.println("Programa cliente iniciado....");
        Socket cliente = new Socket(host, puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR 
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        //Thread.sleep(10000);
        // ENVIO UN SALUDO AL SERVIDOR 
        flujoSalida.writeUTF("Saludos al servidor desde el cliente");

        // CREO FLUJO DE ENTRADA AL SERVIDOR 
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        // EL SERVIDOR ME ENVIA UN MENSAJE    
        System.out.println("Recibiendo del servidor: \n\t" + flujoEntrada.readUTF());

        // CERRAR STREAMS Y SOCKETS 
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();

    }// fin de main 

}// Fin de Ejemplo1Cliente
