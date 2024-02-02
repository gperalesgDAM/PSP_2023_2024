package Ejem11_socket_UDP_hilos;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorUDP {

    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String args[]) throws Exception {
        try {
            // 1. Crear un socket de datagrama en el puerto especificado
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Servidor UDP esperando mensajes...");
            // Usamos un ExecutorService para manejar las conexiones simult�neas en este caso UDP
            //que utiliza un conjunto fijo de cinco hilos en su pool. 
            //Esto significa que, como m�ximo, cinco tareas pueden ejecutarse simult�neamente.
            ExecutorService executorService = Executors.newFixedThreadPool(5);

            while (true) {

                byte[] bufferEntrada = new byte[BUFFER_SIZE];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                // 3. Permanece a la espera de recibir datos del cliente
                //si dos paquetes llegan al mismo tiempo, el servidor solo podr� atender uno de ellos a trav�s de serverSocket.receive(paqueteRecibido). Esto se debe a que el servidor UDP maneja cada paquete 
                //de forma independiente y no hay una conexi�n persistente como en TCP.
                serverSocket.receive(paqueteRecibido);

                // Crear un nuevo hilo para manejar cada solicitud entrante
                executorService.submit(new UDPRequestHandler(serverSocket, paqueteRecibido));

            }//Fin de while

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Fin de main

}//Fin de ServidorUDP


//Cuando el servidor recibe un paquete UDP, crea una nueva instancia de UDPRequestHandler y la env�a al ExecutorService 
//para su ejecuci�n utilizando executorService.submit(...).
//Al utilizar un pool de hilos, ExecutorService reutiliza los hilos existentes en lugar de crear uno nuevo para cada solicitud. Esto mejora la eficiencia del programa 
//al evitar la sobrecarga de crear y destruir hilos continuamente.
// La configuraci�n newFixedThreadPool(5) garantiza que, como m�ximo, cinco tareas se ejecuten simult�neamente.