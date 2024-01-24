package Ejem10_objetos_compartidos;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidorAdivina extends Thread {

    ObjectInputStream fentrada;
    ObjectOutputStream fsalida;
    Socket socket = null;
    ObjetoCompartido objeto;
    int identificador = 0;
    int intentos = 0;

    public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id) {
        this.socket = s;
        this.objeto = objeto;
        this.identificador = id;
        try {
            fsalida = new ObjectOutputStream(socket.getOutputStream());
            fentrada = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado:  " + identificador);

        //Preparar primer envio al cliente
        DatosCliente datos = new DatosCliente("Adivina un número entre 1 y 25", intentos, identificador);
        if (objeto.seAcabo()) {
            datos.setCadena("El juego ha terminado, han adivinado el número");
            datos.setJuega(false);
        }

        try {
            System.out.println("Envio juega: " + datos.isJuega());
            fsalida.reset();
            fsalida.writeObject(datos);
        } catch (IOException e1) {
            System.out.println("Error en el hilo al realizar el primer envio a: " + identificador);
        }

        while (!objeto.seAcabo() && !(datos.getIntentos() == 5)) {
            int numCliente = 0;
            try {
                //Recibir datos del cliente
                datos = (DatosCliente) fentrada.readObject();
                numCliente = Integer.parseInt(datos.getCadena());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Jugar el número
            String cad = objeto.nuevaJugada(identificador, numCliente);
            intentos++;

            datos = new DatosCliente(cad, intentos, identificador);

            if (objeto.seAcabo()) {
                datos.setJuega(false);
                if (identificador == objeto.getGanador()) {
                    datos.setGana(true);
                }
            }

            try {
                fsalida.reset();
                fsalida.writeObject(datos);

            } catch (IOException n1) {
                System.out.println("error recibiendo flujo de salida del jugador" + n1.getMessage());
            } catch (NullPointerException n1) {
                System.out.println("El jugador se ha desconectado");
            }

        } //fwhile

        if (objeto.seAcabo()) {
            System.out.println("El juego se ha acabado");
            System.out.println("Desconecta: " + identificador);
        }

        try {
            fsalida.close();
            fentrada.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error en el hilo");
        }

    }
}
