package Ejem10_objetos_compartidos;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class JugadorAdivina {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 6001;//puerto remoto
        Socket cliente = new Socket(host, puerto);

        ObjectOutputStream fsalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream fentrada = new ObjectInputStream(cliente.getInputStream());

        //Entrada est�ndar
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        //Obtener primer objeto enviado por el servidor
        DatosCliente datos = (DatosCliente) fentrada.readObject();
        int identificador = datos.getIdentificador();

        System.out.println("Id jugador: " + identificador);
        System.out.println(datos.getCadena());

        if (datos.isJuega()) {
            cadena = "";
        }

        while (datos.isJuega() && !cadena.trim().equals("*")) {
            System.out.println("Intento: " + (datos.getIntentos() + 1) + " => Introduce n�mero: ");

            cadena = sc.nextLine();
           // DatosCliente d = new DatosCliente();

            if (!validarCadena(cadena)) {
                continue;
            }

            datos.setCadena(cadena);

            //Enviar datos al servidor, el n�mero le�do por teclado
            fsalida.reset();
            fsalida.writeObject(datos);

            //Recibir datos del servidor
            datos = (DatosCliente) fentrada.readObject();
            System.out.println(datos.getCadena());

            if (datos.getIntentos() >= 5) {
                System.out.println("Juego finalizado");
                cadena = "*";
            }

            if (datos.isGana()) {
                System.out.println("Has ganado!!!");
                cadena = "*";
            } else if (!datos.isJuega()) {
                System.out.println("El juego ha terminado, han adivinado el n�mero");
                cadena = "*";
            }

        }//fwhile
        fsalida.close();
        fentrada.close();
        cliente.close();
        System.out.println("Fin del proceso");
    }

    private static boolean validarCadena(String cadena) {
        //comprueba si la cadena es num�rica
        boolean valor = false;
        try {
            Integer.parseInt(cadena);
            valor = true;
        } catch (NumberFormatException e) {
        }
        return valor;
    }

}
