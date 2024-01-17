/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad1;

/**
 *
 * @author guipe
 */
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) throws IOException {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingresa una dirección IP o un nombre de dominio (o 'salir' para terminar): ");
            String userInput = scanner.nextLine();
            // 80.35.46.56
            //8.8.8.8
            //151.35.46.78
            // Verificar si el usuario desea salir del programa verificando caracteres tanto en minusculas como en mayusculas
            if (userInput.equalsIgnoreCase("salir")) {   
                System.out.println("Saliendo del programa...");
                break;
            }
            
            try {
                InetAddress inetAddress = InetAddress.getByName(userInput);
                
                // Mostrar la información de la dirección IP o el nombre de dominio
                System.out.println("Host: " + inetAddress.getHostName());
                System.out.println("Dirección IP: " + inetAddress.getHostAddress());
                
                // Verificar la conectividad con el host
                if (inetAddress.isReachable(5000)) { // Timeout de 5 segundos
                    System.out.println("El host está disponible y responde a pings.");
                } else {
                    System.out.println("El host no está disponible o no responde a pings.");
                }
            } catch (UnknownHostException e) { //Se da cuando en el momento de crear la instancia no se puede resolver la IP para ese host
                System.out.println("No se pudo resolver la dirección IP para el host ingresado.");
            } catch (IOException e) {
                System.out.println("Error al intentar verificar la conectividad con el host.");
            }
        }
        
        // Cerrar el Scanner al salir del ciclo
        scanner.close();
    }
}
