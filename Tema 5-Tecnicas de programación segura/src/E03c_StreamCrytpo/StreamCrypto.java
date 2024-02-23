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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author guipe
 */
public class StreamCrypto {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        File file;
        String filePath = "./archivos/E03c.txt";

        file = new File(filePath);

        //Se define el objeto Cipher (Algoritmo/modo/relleno)
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding"); //DESede
        // Configuramos el modo de CIFRADO
        byte[] valorClave = "12345678123456781234567812345678".getBytes();

        // CIFRADO DEL STREAM (fichero a.txt)
        c.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(valorClave, "AES"));

        try (OutputStream outputStream = new BufferedOutputStream(
                new CipherOutputStream(new FileOutputStream(file), c))) {
            for (int i = 0; i < 10; i++) {
                outputStream.write(new String("Hello World\n").getBytes());
            }

        }

        // DESCIFRADO DEL STREAM (fichero a.txt)
        c.init(Cipher.DECRYPT_MODE,
                new SecretKeySpec(valorClave, "AES"));

        try (InputStream inputStream = new BufferedInputStream(
                new CipherInputStream(new FileInputStream(file), c))) {

            System.out.println("Contenido del fichero (descifrado):\n" + new String(inputStream.readAllBytes()));
        }

    }
}
