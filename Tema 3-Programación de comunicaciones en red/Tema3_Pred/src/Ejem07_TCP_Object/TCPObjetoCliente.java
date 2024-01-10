package Ejem07_TCP_Object;

import java.io.ObjectInputStream;
import java.net.Socket;

public class TCPObjetoCliente {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciado...");
        Socket cliente = new Socket(host, puerto);

        // flujo de entrada para objetos
        ObjectInputStream dato = new ObjectInputStream(cliente.getInputStream());
        Persona persona = (Persona) dato.readObject();
        //(Persona) Para convertir el objeto que se lee del flujo de entrada al tipo Persona. 
        //Esto se hace porque readObject() devuelve un objeto genérico (Object) y necesitamos 
        //convertirlo de nuevo a Persona para acceder a los métodos específicos de esa clase.
        System.out.println("Recibo " + persona.getNombre() + "*" + persona.getEdad());

        dato.close();
        cliente.close();
    }

}
