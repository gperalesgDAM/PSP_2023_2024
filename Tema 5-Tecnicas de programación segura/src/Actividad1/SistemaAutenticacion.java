/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad1;

/**
 *
 * @author guipe
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaAutenticacion {

    
    public static List<User> listaDeUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Men� de opciones:");
            System.out.println("1. A�adir nuevo usuario");
            System.out.println("2. Logarse en la sesi�n");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opci�n: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de l�nea despu�s de leer el n�mero
                switch (opcion) {
                    case 1:
                        a�adirNuevoUsuario(scanner);
                        break;
                    case 2:
                        logarseEnSesion(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                    default:
                        System.err.println("Opci�n no v�lida. Por favor, seleccione una opci�n v�lida.");
                        scanner.close();
                        
                }
            } catch (InputMismatchException e) {
                System.err.println("Opci�n no v�lida. Por favor, seleccione una opci�n v�lida.");
                
                // Puedes hacer algo m�s con la excepci�n si es necesario
            }

        }
    }

    private static void a�adirNuevoUsuario(Scanner scanner) {
        System.out.print("Introduzca el nombre del nuevo usuario: ");
        String nombreUsuario = scanner.nextLine();

 

    }

    private static void logarseEnSesion(Scanner scanner) {
        System.out.print("Introduzca el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();


    }

    private static byte[] generarSalt() {

    }

    private static byte[] calcularHashContrase�a(String contrase�a, byte[] salt) {

    }

    private static User buscarUsuarioPorNombre(List<User> listaDeUsuarios, String nombre) {

    }
    public static String valorHexadecimal2(byte[] bytes) {
        StringBuilder result = new StringBuilder();     //M�s eficiente
        for (byte b : bytes) {
            result.append(String.format("%02x", b)); //asegurar que cada byte se represente con dos caracteres hexadecimales
        }
        return result.toString();
    }
}
