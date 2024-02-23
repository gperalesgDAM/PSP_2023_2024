/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03a_CifradoDescifrado_AES_16;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import javax.crypto.BadPaddingException;

/**
 *
 * @author guipe
 */
public class DescifradorAESSimple {

    public static void main(String[] args) {

        final String NOMBRE_FICHERO = "./archivos/mensaje_cifrado.txt";
        final String PASSWORD = "0123456789124567";
        final int LONGITUD = 16; //Expresado en bytes
        try {

            File file = new File(NOMBRE_FICHERO);
            Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String textoCifrado = br.readLine();
            String textoEnClaro = AESSimpleManager.descifrar(textoCifrado, clave);
            br.close();
            System.out.println("El texto descifrado es: " + textoEnClaro);

        } catch (BadPaddingException e) {
            // Manejar el caso en que la contrase�a no sea la correcta
            System.out.println("Error: Contrase�a incorrecta para descifrar el mensaje.");
        } catch (IllegalArgumentException e) {
            // Manejar el caso de una combinaci�n de offset/length inv�lida
            System.out.println("Error: Combinaci�n de offset/length inv�lida al construir la clave.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
