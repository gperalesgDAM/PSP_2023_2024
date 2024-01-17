package Ejem02b_socket_TCP;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SocketCliente {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int puerto1 = 6000;//puerto remoto 
        int puerto2 = 6001;//puerto remoto 
        int puerto3 = 6002;//puerto remoto 
        int puerto4 = 6003;//puerto remoto 
        int puerto5 = 6004;//puerto remoto
        // ABRIR SOCKET 
        
        Socket cliente1 = new Socket(host, puerto1);
        System.out.println("Programa cliente iniciado en el puerto "+ cliente1.getLocalPort()+ " contra el puerto remoto "+ cliente1.getPort());
        Socket cliente2 = new Socket(host, puerto2);
        System.out.println("Programa cliente iniciado en el puerto "+ cliente2.getLocalPort()+ " contra el puerto remoto "+ cliente2.getPort());
        Socket cliente3 = new Socket(host, puerto3);
        System.out.println("Programa cliente iniciado en el puerto "+ cliente3.getLocalPort()+ " contra el puerto remoto "+ cliente3.getPort());
        Socket cliente4 = new Socket(host, puerto4);
        System.out.println("Programa cliente iniciado en el puerto "+ cliente4.getLocalPort()+ " contra el puerto remoto "+ cliente4.getPort());
        Socket cliente5 = new Socket(host, puerto5);
        System.out.println("Programa cliente iniciado en el puerto "+ cliente5.getLocalPort()+ " contra el puerto remoto "+ cliente5.getPort());
        
        // CREO FLUJO DE SALIDA AL SERVIDOR 
        DataOutputStream flujoSalida1 = new DataOutputStream(cliente1.getOutputStream());
        PrintWriter flujoSalida2 = new PrintWriter(cliente2.getOutputStream(), true);
        PrintWriter flujoSalida3 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente3.getOutputStream())), true);
        DataOutputStream flujoSalida4 = new DataOutputStream(cliente4.getOutputStream());
        OutputStreamWriter flujoSalida5 = new OutputStreamWriter(cliente5.getOutputStream());
        
        // CREO FLUJO DE ENTRADA AL SERVIDOR 
        DataInputStream flujoEntrada1 = new DataInputStream(cliente1.getInputStream());
        BufferedReader flujoEntrada2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
        BufferedReader flujoEntrada3 = new BufferedReader(new InputStreamReader(cliente3.getInputStream()));
        DataInputStream flujoEntrada4 = new DataInputStream(cliente4.getInputStream());
        InputStreamReader flujoEntrada5 = new InputStreamReader(cliente5.getInputStream(), StandardCharsets.UTF_8);
        // ENVIO DE DATOS CON LOS FLUJOS
        flujoSalida1.writeUTF("Saludos al servidor desde el cliente con el flujo de salida 1");
        flujoSalida2.println("Saludos al servidor desde el cliente con el flujo de salida 2"); 
        flujoSalida3.println("Saludos al servidor desde el cliente con el flujo de salida 3");
        flujoSalida4.writeFloat(3.1416f);
        flujoSalida5.write("Saludos al servidor desde el cliente con el flujo de salida 4");
        flujoSalida5.flush();
        cliente5.shutdownOutput();
        // EL SERVIDOR ME ENVIA UN MENSAJE    con salto de linea y tabulador 
        System.out.println("Recibiendo del servidor con el flujo de entrada 1: \n\t" + flujoEntrada1.readUTF());
        System.out.println("Recibiendo del servidor con el flujo de entrada 2:: \n\t" + flujoEntrada2.readLine());
        System.out.println("Recibiendo del servidor con el flujo de entrada 3:: \n\t" + flujoEntrada3.readLine());
        System.out.println("Número recibido del servidor con el flujo de entrada 4: \n\t " + flujoEntrada4.readFloat());
        StringBuilder mensajeRecibido = new StringBuilder();
        int car;
        while ((car = flujoEntrada5.read()) != -1) {
            mensajeRecibido.append((char) car);
        }
        System.out.println("Recibiendo del cliente con el flujo de entrada 5: \n\t"  + mensajeRecibido);
        
        // CERRAR STREAMS Y SOCKETS 
        flujoEntrada1.close();
        flujoEntrada2.close();
        flujoEntrada3.close();
        flujoEntrada4.close();
        flujoEntrada5.close();
        flujoSalida1.close();
        flujoSalida2.close();
        flujoSalida3.close();
        flujoSalida4.close();
        flujoSalida5.close();
        cliente1.close();
        cliente2.close();
        cliente3.close();
        cliente4.close();
        cliente5.close();

    }// fin de main 

}// Fin de Ejemplo1Cliente
