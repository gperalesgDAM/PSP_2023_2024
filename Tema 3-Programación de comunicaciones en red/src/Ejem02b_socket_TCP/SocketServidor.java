package Ejem02b_socket_TCP;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SocketServidor {

    public static void main(String[] arg) throws IOException {

        int puerto1 = 6000;// Puerto 
        int puerto2 = 6001;// Puerto 
        int puerto3 = 6002;// Puerto 
        int puerto4 = 6003;// Puerto
        int puerto5 = 6004;// Puerto
        ServerSocket servidor1 = new ServerSocket(puerto1);
        ServerSocket servidor2 = new ServerSocket(puerto2);
        ServerSocket servidor3 = new ServerSocket(puerto3);
        ServerSocket servidor4 = new ServerSocket(puerto4);
        ServerSocket servidor5 = new ServerSocket(puerto5);
        System.out.println("Esperando al cliente en el puerto " + servidor1.getLocalPort() + ".......");
        System.out.println("Esperando al cliente en el puerto " + servidor2.getLocalPort() + ".......");
        System.out.println("Esperando al cliente en el puerto " + servidor3.getLocalPort() + ".......");
        System.out.println("Esperando al cliente en el puerto " + servidor4.getLocalPort() + ".......");
        System.out.println("Esperando al cliente en el puerto " + servidor5.getLocalPort() + ".......");
        Socket cliente1 = servidor1.accept();
        Socket cliente2 = servidor2.accept();
        Socket cliente3 = servidor3.accept();
        Socket cliente4 = servidor4.accept();
        Socket cliente5 = servidor5.accept();
        // CREO FLUJO DE SALIDA AL CLIENTE 
        DataOutputStream flujoSalida1 = new DataOutputStream(cliente1.getOutputStream());
        PrintWriter flujoSalida2 = new PrintWriter(cliente2.getOutputStream(), true);
        PrintWriter flujoSalida3 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente3.getOutputStream())), true);
        DataOutputStream flujoSalida4 = new DataOutputStream(cliente4.getOutputStream());
        OutputStreamWriter flujoSalida5 = new OutputStreamWriter(cliente5.getOutputStream());

        
        // CREO FLUJO DE ENTRADA DEL CLIENTE    
        DataInputStream flujoEntrada1 = new DataInputStream(cliente1.getInputStream());
        BufferedReader flujoEntrada2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
        BufferedReader flujoEntrada3 = new BufferedReader(new InputStreamReader(cliente3.getInputStream()));
        DataInputStream flujoEntrada4 = new DataInputStream(cliente4.getInputStream());        
        InputStreamReader flujoEntrada5 = new InputStreamReader(cliente5.getInputStream(), StandardCharsets.UTF_8);
        // ENVIO UN SALUDO AL CLIENTE 
        flujoSalida1.writeUTF("Saludos al cliente del servidor por el flujo de salida 1");
        flujoSalida2.println("Saludos al cliente del servidor por el flujo de salida 2");
        flujoSalida3.println("Saludos al cliente del servidor por el flujo de salida 3");
        flujoSalida4.writeFloat(3.1416f);
        flujoSalida5.write("Saludos al cliente desde el servidor con el flujo de salida 4");
        flujoSalida5.flush();
        cliente5.shutdownOutput();
        // RECIBO UN SALUDO DEL CLIENTE  
        System.out.println("Recibiendo del cliente con el flujo de entrada 1: \n\t" + flujoEntrada1.readUTF());
        System.out.println("Recibiendo del cliente con el flujo de entrada 2: \n\t" + flujoEntrada2.readLine());
        System.out.println("Recibiendo del cliente con el flujo de entrada 3: \n\t" + flujoEntrada3.readLine());
        System.out.println("Número recibido del cliente con el flujo de entrada 4: \n\t " + flujoEntrada4.readFloat());
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
        servidor1.close();
        servidor2.close();
        servidor3.close();
        servidor4.close();
        servidor5.close();

    }// main 

}// fin de Ejemplo1Servidor
