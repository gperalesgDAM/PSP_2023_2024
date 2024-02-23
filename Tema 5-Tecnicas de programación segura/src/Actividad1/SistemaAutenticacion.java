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
            System.out.println("Menú de opciones:");
            System.out.println("1. Añadir nuevo usuario");
            System.out.println("2. Logarse en la sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea después de leer el número
                switch (opcion) {
                    case 1:
                        añadirNuevoUsuario(scanner);
                        break;
                    case 2:
                        logarseEnSesion(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                    default:
                        System.err.println("Opción no válida. Por favor, seleccione una opción válida.");
                        scanner.close();
                        
                }
            } catch (InputMismatchException e) {
                System.err.println("Opción no válida. Por favor, seleccione una opción válida.");
                
                // Puedes hacer algo más con la excepción si es necesario
            }

        }
    }

    private static void añadirNuevoUsuario(Scanner scanner) {
        System.out.print("Introduzca el nombre del nuevo usuario: ");
        String nombreUsuario = scanner.nextLine();

 

    }

    private static void logarseEnSesion(Scanner scanner) {
        System.out.print("Introduzca el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();


    }

    private static byte[] generarSalt() {

    }

    private static byte[] calcularHashContraseña(String contraseña, byte[] salt) {

    }

    private static User buscarUsuarioPorNombre(List<User> listaDeUsuarios, String nombre) {

    }
    public static String valorHexadecimal2(byte[] bytes) {
        StringBuilder result = new StringBuilder();     //Más eficiente
        for (byte b : bytes) {
            result.append(String.format("%02x", b)); //asegurar que cada byte se represente con dos caracteres hexadecimales
        }
        return result.toString();
    }
}
