/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03b_CifradoDescifrado_AES_16_CBC;

/**
 *
 * @author guipe
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESSimpleManager {

//    public static SecretKey obtenerClave(String password, int longitud) {
//        return new SecretKeySpec(password.getBytes(), 0, longitud, "AES");
//    }

        public static Key obtenerClave(String password, int longitud) {
        //La longitud puede ser de 16, 24,o 32 bytes para construir claves AES-128, AES-192 o AES-256, respectivamente. 
        
        Key clave = new SecretKeySpec(password.getBytes(), 0, longitud, "AES");
        //Offset: Es el índice en el array de bytes desde donde comenzará a construir la clave
        //SecretKeySpec: se utiliza para construir objetos de clave secretas a partir de bytes que representan una clave en bruto
        return clave;
    }
    public static String cifrar(String textoEnClaro, Key key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // Configuramos el modo de CIFRADO y el vector de inicialización (IV)
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String descifrar(String textoCifrado, Key key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // Configuramos el modo de DESCIFRADO y el vector de inicialización (IV)
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(plainText);
    }

}
