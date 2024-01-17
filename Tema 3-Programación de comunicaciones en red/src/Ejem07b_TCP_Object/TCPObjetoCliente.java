package Ejem07b_TCP_Object;

import java.io.ObjectInputStream;
import java.net.Socket;

public class TCPObjetoCliente {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciado...");
        Socket cliente = new Socket(host, puerto);

        // flujo de entrada para objetos
        ObjectInputStream inputObjeto = new ObjectInputStream(cliente.getInputStream());

        while (true) {

            Persona persona = (Persona) inputObjeto.readObject();
            System.out.println("Recibo: " + persona.getNombre() + ", " + persona.getEdad());

            if (persona.isUltima()) {
                break;
            }
        }

        inputObjeto.close();
        cliente.close();
    }

}
