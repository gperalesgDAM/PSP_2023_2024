package E04_CifradoDescifradoRSA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;

public class CifradoRSA {

  private static final String ALGORITMO_CLAVE_PUBLICA = "RSA";
  private static final String FICH_CLAVE_PUB = "./archivos/clavepublica.der";
   private static final String FICHERO = "./archivos/fichero.txt";
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce un texto para cifrar con la clave pública: ");
        String cadenaEnClaro = in.readLine();

        byte clavePubCodif[]; //Convertimos el fichero de clave publica en bytes
        try {
            FileInputStream fisClavePub = new FileInputStream(FICH_CLAVE_PUB);
            clavePubCodif = fisClavePub.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: no existe fichero de clave pública %s\n.", FICH_CLAVE_PUB);
            return;
        } catch (IOException e) {
            System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", FICH_CLAVE_PUB);
            return;
        }

//      RSAPublicKeySpec keySpec = new RSAPublicKeySpec(
//        new BigInteger(valorClavePub), ALGORITMO_CLAVE_PUBLICA);
        KeyFactory keyFactory;
        try {

      keyFactory = KeyFactory.getInstance(ALGORITMO_CLAVE_PUBLICA);
      X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(clavePubCodif);
      PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

      byte[] mensajeEnClaro = cadenaEnClaro.getBytes("UTF-8");

      Cipher cifrado = Cipher.getInstance(ALGORITMO_CLAVE_PUBLICA);
      cifrado.init(Cipher.ENCRYPT_MODE, clavePublica);

      byte[] mensajeCifrado = cifrado.doFinal(mensajeEnClaro);
      String mensajeBase64 = Base64.getEncoder().encodeToString(mensajeCifrado); //ME almaceneo el texto codificado en base 64
      

      System.out.printf("Texto cifrado codificado en base 64 como texto:\n%s\n",
              mensajeBase64.replaceAll("(.{76})", "$1\n"));
      File fichero = new File (FICHERO);
      Files.write(fichero.toPath(), mensajeBase64.getBytes("UTF-8"));//Almaceno el resultado en un fichero de texto

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
