package E02a_GeneracionHashTexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneracionHash {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Introduce un texto para obtener su hash (escribe \"final para salir\": ");
            String cadena = "";
            String algoritmo = "";

            try {
                cadena = in.readLine();
                if (cadena.equals("final")) {
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(GeneracionHash.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Elige uno de los siguiente algorítmos disponibles a utilizar: ");
            providers();
            try {
                algoritmo = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(GeneracionHash.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                byte[] bytes = cadena.getBytes(); //Se convierte la cadena en un array de bytes

                // Obtenemos un ENGINE que implementa el algoritmo especificado
                // Se puede indicar cualquier algoritmo disponible en el sistema
                MessageDigest md = MessageDigest.getInstance(algoritmo);
                md.getProvider();

                // Realiza el resumen de los datos pasados por parámetro
                md.update(bytes);
                // Completa el cálculo del valor del hash y devuelve el resumen
                byte[] hash = md.digest();

                // Reinicia el objeto para un nuevo uso dentro de bucles
                md.reset();
                System.out.printf("Cadena: [%s]\nHash: [%s]\n", cadena, valorHexadecimal(hash));
                System.out.printf("Cadena: [%s]\nHash: [%s]\n", cadena, valorHexadecimal2(hash));
                System.out.printf("Cadena: [%s]\nHash: [%s]\n", cadena, valorHexadecimal3(hash));
                System.out.println("");
            } catch (NoSuchAlgorithmException e) { //Excepción al intentar utilizar el algoritmo de hash
                System.out.println("No disponible algoritmo de hash");
            }
        }
    }
//Toma un array de bytes como entrada y devuelve una representación hexadecimal de esos bytes en forma de cadena de caracteres
//Los tres métodos
    static String valorHexadecimal(byte[] bytes) {
        String result = "";
        for (byte b : bytes) {
            result += String.format(String.format("%x", b));
        }
        return result;
    }

    static String valorHexadecimal2(byte[] bytes) {
        StringBuilder result = new StringBuilder();     //Más eficiente
        for (byte b : bytes) {
            result.append(String.format("%02x", b)); //asegurar que cada byte se represente con dos caracteres hexadecimales
        }
        return result.toString();
    }

    static String valorHexadecimal3(byte[] bytes) {
        String result = String.format("%064x", new BigInteger(1, bytes)); //asegurar que la cadena resultante tenga una longitud fija de 64 caracteres hexadecimales
        return result;
    }
    //Determinar los proveedores de mi sistema
    public static void providers() {
        //Se define el tipo de algoritmo como MessageDigest
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
        //Se obtiene la lista de los proveedores de seguridad instalados
        Provider[] proveedores = Security.getProviders();

        for (Provider proveedor : proveedores) {
            //Por cada proveedor se obtiene el conjunto de servicios.
            Set<Provider.Service> servicios = proveedor.getServices();
            for (Provider.Service servicio : servicios) {
                //Se filtran los servicios por el tipo
                if (servicio.getType().equals(TIPO_MESSAGE_DIGEST)) {
                    System.out.println(servicio.getAlgorithm());
                }
            }
        }
    }

}
