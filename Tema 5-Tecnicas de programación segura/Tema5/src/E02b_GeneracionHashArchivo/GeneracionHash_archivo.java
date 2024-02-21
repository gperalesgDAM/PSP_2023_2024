package E02b_GeneracionHashArchivo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class GeneracionHash_archivo {

    public static void main(String[] args) throws IOException {

        //MessageDigest md;
        try {
            String rutaArchivo = "archivos/prueba.txt";

            Path path = Paths.get(rutaArchivo);
            byte[] bytes = Files.readAllBytes(path);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            byte[] hash = md.digest();

            System.out.printf("Hash del archivo: [%s]\n", valorHexadecimal(hash));
            System.out.println("");
        } catch (NoSuchAlgorithmException e) { //Excepción al intentar utilizar el algoritmo de hash
            System.out.println("No disponible algoritmo de hash");
        }

    }
//Toma un array de bytes como entrada y devuelve una representación hexadecimal de esos bytes en forma de cadena de caracteres

    static String valorHexadecimal(byte[] bytes) {
        String result = "";
        for (byte b : bytes) {
            result += String.format(String.format("%x", b));
        }
        return result;
    }


}
