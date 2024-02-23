/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E02c_SecureRandomExample;

/**
 *
 * @author guipe
 */
//Este ejemplo utiliza SecureRandom para generar un array de bytes aleatorios criptogr�ficamente seguros. Es importante utilizar SecureRandom en lugar de Random 
//cuando se necesitan n�meros aleatorios para prop�sitos criptogr�ficos, ya que SecureRandom est� dise�ado espec�ficamente para ofrecer mayor seguridad.
import java.security.SecureRandom;

public class SecureRandomExample {
    public static void main(String[] args) {
        // Crear una instancia de SecureRandom
        SecureRandom secureRandom = new SecureRandom();

        // Generar un n�mero aleatorio criptogr�ficamente seguro (byte array)
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        // Mostrar el n�mero aleatorio
        System.out.println("N�mero aleatorio criptogr�ficamente seguro: " + bytesToHex(randomBytes));
    }

    // M�todo para convertir un array de bytes a una representaci�n hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
