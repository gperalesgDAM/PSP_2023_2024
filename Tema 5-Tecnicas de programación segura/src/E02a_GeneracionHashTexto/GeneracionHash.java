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
            algoritmo=providers();

            try {

                // Obtenemos un ENGINE que implementa el algoritmo especificado
                // Se puede indicar cualquier algoritmo disponible en el sistema
                MessageDigest md = MessageDigest.getInstance(algoritmo);
                System.out.println("Nombre  del proveedor: " + md.getProvider().getName());

                //Se convierte la cadena en un array de bytes
                byte[] bytes = cadena.getBytes();
                // Procesar los bytes del mensaje usando update
                md.update(bytes);
                // Completa el cálculo del valor del hash y devuelve el resumen
                byte[] hash = md.digest();

                //byte[] hash = md.digest(cadena.getBytes());
                // Reinicia el objeto para un nuevo uso dentro de bucles
                md.reset();
                System.out.printf("Cadena1: [%s]\nHash: [%s]\n", cadena, valorHexadecimal(hash));
                System.out.printf("Cadena2: [%s]\nHash: [%s]\n", cadena, valorHexadecimal2(hash));
                System.out.printf("Cadena3: [%s]\nHash: [%s]\n", cadena, valorHexadecimal3(hash));
                printHashBitByBit(hash);
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

    //%02x: Especifica un formato de cadena para imprimir un número hexadecimal (x). El 0 indica que se deben rellenar con ceros a la izquierda, 
    //y el 2 indica que se deben utilizar al menos dos caracteres.
    
    //Cuando se representa un número en formato hexadecimal, cada dígito hexadecimal corresponde a cuatro bits. 
    //Un byte está formado por 8 bits, por lo que puede tener un valor entre 0 y 255 en decimal. 
    //En formato hexadecimal, esto significa que un byte puede ser representado por dos dígitos hexadecimales.
    //Un byte es una unidad de almacenamiento de información y puede representar valores en el rango de 0 a 255 (en formato decimal) o de 00 a FF (en formato hexadecimal). 
    //Cada dígito hexadecimal corresponde a 4 bits, por lo que dos dígitos hexadecimales representan un byte completo.
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

    static void printHashBitByBit(byte[] hash) {
        int countBytes = 0;
        int countBits = 0;
        for (byte b : hash) {

            for (int i = 7; i >= 0; i--) {
                // Obtener el i-ésimo bit del byte
                int bit = (b >> i) & 1;
                System.out.print(bit);
                countBits++;
            }
            System.out.println();
            countBytes++;
        }
        System.out.println();  // Nueva línea al final para mayor legibilidad
        System.out.println("Numero de bytes que utiliza el algoritmo escogido: " + countBytes + "==>" + countBits + "bits");  // Nueva línea al final para mayor legibilidad
    }

    
    
    //Determinar los proveedores de mi sistema
    public static String providers() {
        //Se define el tipo de algoritmo como MessageDigest
        //se utiliza para obtener el nombre simple de la clase representada por el objeto MessageDigest.class.
//        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
//        System.out.println(TIPO_MESSAGE_DIGEST);
        //Se obtiene la lista de los proveedores de seguridad instalados
        Provider[] proveedores = Security.getProviders();

        for (Provider proveedor : proveedores) {
            //Por cada proveedor se obtiene el conjunto de servicios.
            Set<Provider.Service> servicios = proveedor.getServices();
            for (Provider.Service servicio : servicios) {
                //Se filtran los servicios por el tipo
                //System.out.println("El algoritmo " + servicio.getAlgorithm() + " es de tipo " + servicio.getType());
                if (servicio.getType().equals("MessageDigest")) {

                    System.out.println(servicio.getAlgorithm());
                }
            }
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Elige uno de estos algorítmos disponibles: ");

        try {
            return in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionHash.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
        }
    }

}
