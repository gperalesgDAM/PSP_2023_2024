/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03c_StreamCrytpo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author guipe
 * En el modo  ECB (Electronic CodeBook), no se utiliza Initialization Vector (IV) (es menos seguro 
 * En el modo CBC, el IV es un valor aleatorio que se utiliza para mezclar los bloques de datos antes de cifrarlos, 
 * y este IV debe ser conocido tanto durante el cifrado como durante el descifrado.
 */


public class StreamCryptoAES {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        String filePath1 = "./archivos/E03c_AES_ECB.txt";
        String filePath2 = "./archivos/E03c_AES_CBC.txt";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        //Se define el objeto Cipher (Algoritmo/modo/relleno)
        Cipher c1 = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
        Cipher c2 = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
        // Configuramos el modo de CIFRADO
        byte[] valorClave = "1234567812345678".getBytes(); //ASi implementación de 128 bits 
      //  byte[] valorClave = "12345678123456781234567812345678".getBytes(); //ASi implementación de 256 bits
        
        // CIFRADO DEL STREAM con modo ECB
        c1.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(valorClave, "AES"));
        
        //DIFRADO CON CBC ES NECESARIO UN INICIAL VECTOR
        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        try {
            c2.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(valorClave, "AES"), new IvParameterSpec(iv));
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(StreamCryptoAES.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        try {
            outputStream1 = new BufferedOutputStream(new CipherOutputStream(new FileOutputStream(file1), c1));
            outputStream2 = new BufferedOutputStream(new CipherOutputStream(new FileOutputStream(file2), c2)); 
            for (int i = 0; i < 10; i++) {
                outputStream1.write(new String("Hello World desde out1\n").getBytes());
                outputStream2.write(new String("Hello World desde out2\n").getBytes());
            }
        } finally {
            if (outputStream1 != null) {
                outputStream1.close();
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
        }

        // DESCIFRADO DEL STREAM con modo ECB
        c1.init(Cipher.DECRYPT_MODE,
                new SecretKeySpec(valorClave, "AES"));

        try (InputStream inputStream = new BufferedInputStream(
                new CipherInputStream(new FileInputStream(file1), c1))) {

            System.out.println("Contenido del fichero (descifrado):\n" + new String(inputStream.readAllBytes()));
        }
        

        // DESCIFRADO DEL STREAM con modo CBC
        try {
            c2.init(Cipher.DECRYPT_MODE, new SecretKeySpec(valorClave, "AES"), new IvParameterSpec(iv));
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(StreamCryptoAES.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (InputStream inputStream = new BufferedInputStream(
                new CipherInputStream(new FileInputStream(file2), c2))) {

            System.out.println("Contenido del fichero (descifrado):\n" + new String(inputStream.readAllBytes()));
        }
    }
}
