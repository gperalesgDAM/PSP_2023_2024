/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03b_CifradoDescifrado_AES_16_CBC;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;


/**
 *
 * @author guipe
 */
public class CifradorDescifradorAESSimple {

    public static void main(String[] args) {

        final String NOMBRE_FICHERO = "./archivos/mensaje_cifrado.txt";
        final String PASSWORD = "0123456789124567";
        final String TEXTO_EN_CLARO = "La clave secreta de las caja fuerte es 3842873110";
        final int LONGITUD = 16; //Expresado en bytes 
        try {

            Key claveCifrar = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD);
            String textoEnClaro = TEXTO_EN_CLARO;
                    // Se genera un IV (Vector de Inicialización) aleatorio
        byte[] iv = new byte[16];
            new SecureRandom().nextBytes(iv);
            String textoCifradoEscritura = AESSimpleManager.cifrar(textoEnClaro, claveCifrar,iv);
            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifradoEscritura);
            pw.close();
            System.out.println("El mensaje se ha cifrado correctamente");
            
                 try {

            File file = new File(NOMBRE_FICHERO);
            Key claveDescifrar = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String textoCifradoLectura = br.readLine();
            String textoEnClaroLectura = AESSimpleManager.descifrar(textoCifradoLectura, claveDescifrar,iv);
            br.close();
            System.out.println("El texto descifrado es: " + textoEnClaro);

        } catch (BadPaddingException e) {
            // Manejar el caso en que la contraseña no sea la correcta
            System.out.println("Error: Contraseña incorrecta para descifrar el mensaje.");
        } catch (IllegalArgumentException e) {
            // Manejar el caso de una combinación de offset/length inválida
            System.out.println("Error: Combinación de offset/length inválida al construir la clave.");
        } catch (Exception e) {
            e.printStackTrace();
        }  
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
