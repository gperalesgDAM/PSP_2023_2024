/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E02c_SecureRandomExample;

/**
 *
 * @author guipe
 */
//Este ejemplo utiliza SecureRandom para generar un array de bytes aleatorios criptográficamente seguros. Es importante utilizar SecureRandom en lugar de Random 
//cuando se necesitan números aleatorios para propósitos criptográficos, ya que SecureRandom está diseñado específicamente para ofrecer mayor seguridad.
import java.security.SecureRandom;

public class SecureRandomExample {
    public static void main(String[] args) {
        // Crear una instancia de SecureRandom
        SecureRandom secureRandom = new SecureRandom();

        // Generar un número aleatorio criptográficamente seguro (byte array)
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        // Mostrar el número aleatorio
        System.out.println("Número aleatorio criptográficamente seguro: " + bytesToHex(randomBytes));
    }

    // Método para convertir un array de bytes a una representación hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
