/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03a_CifradoDescifrado_AES_16_ECB;


import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author guipe
 */
public class AESSimpleManager {

    public static Key obtenerClave(String password, int longitud) {
        //La longitud puede ser de 16, 24,o 32 bytes para construir claves AES-128, AES-192 o AES-256, respectivamente. 
        
        Key clave = new SecretKeySpec(password.getBytes(), 0, longitud, "AES");
        //Offset: Es el índice en el array de bytes desde donde comenzará a construir la clave
        //SecretKeySpec: se utiliza para construir objetos de clave secretas a partir de bytes que representan una clave en bruto
        return clave;
    }

    public static String cifrar(String textoEnClaro, Key key) throws Exception {
        //Se define el objeto Cipher (Algoritmo/modo/relleno)
        //PKCS5Padding es un esquema de relleno que añade bytes adicionales al final de los datos antes de cifrarlos, 
        //de manera que la longitud total sea un múltiplo del tamaño del bloque de cifrado (16 bytes==>128 bits en AES).
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // Configuramos el modo de CIFRADO
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Aquí leemos la información que queremos cifrar
         // Puede ser una cadena o leerla de un archivo
        byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
        
    }

    public static String descifrar(String textoCifrado, Key key) throws Exception {
        //Se define el objeto Cipher (Algoritmo/modo/relleno)
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // Configuramos el modo de DESCIFRADO
        cipher.init(Cipher.DECRYPT_MODE, key);
         // Aquí leemos la información que queremos descifrar
         // Puede ser una cadena o leerla de un archivo
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(plainText);

    }

    
}
