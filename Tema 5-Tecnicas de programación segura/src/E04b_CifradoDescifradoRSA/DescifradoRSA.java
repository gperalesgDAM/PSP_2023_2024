package E04b_CifradoDescifradoRSA;

import E04_CifradoDescifradoRSA.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;

public class DescifradoRSA {

    private static final String ALGORITMO_CLAVE_PUBLICA = "RSA";
    private static final String FICH_CLAVE_PRIV = "./archivos/claveprivada.pkcs8";
    private static final String FICHERO = "./archivos/fichero";

    public static void main(String[] args) throws IOException {
for (int i = 1; i < 5; i++) {
    String ficheroAleer=FICHERO+i+".txt";
        BufferedReader reader = new BufferedReader(new FileReader(ficheroAleer));

        String textoCifrado = reader.readLine();
        System.out.println("El mensaje cifrado es: " + textoCifrado);

        byte clavePrivCodif[];
        try {
            FileInputStream fisClavePriv = new FileInputStream(FICH_CLAVE_PRIV);
            clavePrivCodif = fisClavePriv.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: no existe fichero de clave pública %s\n.", FICH_CLAVE_PRIV);
            return;
        } catch (IOException e) {
            System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", FICH_CLAVE_PRIV);
            return;
        }

        KeyFactory keyFactory;
        try {

            keyFactory = KeyFactory.getInstance(ALGORITMO_CLAVE_PUBLICA);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(clavePrivCodif);
            PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);

            byte[] mensajeCifrado = Base64.getDecoder().decode(textoCifrado);

            Cipher cifrado = Cipher.getInstance(ALGORITMO_CLAVE_PUBLICA);
            cifrado.init(Cipher.DECRYPT_MODE, clavePrivada);

            byte[] mensajeDescifrado = cifrado.doFinal(mensajeCifrado);

            System.out.printf("Texto descifrado de "+ficheroAleer+":\n%s\n", new String(mensajeDescifrado, "UTF-8"));

        } catch (NoSuchAlgorithmException e) {
            System.out.printf("ERROR: no existe algoritmo de cifrado %s.\n.", ALGORITMO_CLAVE_PUBLICA);
        } catch (InvalidKeySpecException e) {
            System.out.println("ERROR: especificación de clave no válida.");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.out.println("Clave no válida.");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.out.println("Tamaño de bloque no válido.");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.out.println("Excepción con relleno.");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.out.println("Excepción con relleno.");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERROR: codificación de caracteres UTF-8 no soportada.");
        }
}
    }

}
