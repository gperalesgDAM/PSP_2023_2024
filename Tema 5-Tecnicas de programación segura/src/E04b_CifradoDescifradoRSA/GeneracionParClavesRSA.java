package E04b_CifradoDescifradoRSA;


import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class GeneracionParClavesRSA {

  private static final String ALGORITMO_CLAVE_PUBLICA = "RSA";
  private static final int TAM_CLAVE = 1024;   //Se utilizar� RSA de 1024 bits
  private static SecureRandom algSeguroGenNumAleat;
  private static final String NOM_FICH_CLAVE_PUBLICA = "./archivos/clavepublica.der"; 
//X.509, que es un est�ndar ampliamente utilizado para la representaci�n de certificados y claves p�blicas. En un archivo con extensi�n .der 
  private static final String NOM_FICH_CLAVE_PRIVADA = "./archivos/claveprivada.pkcs8";
// PKCS8EncodedKeySpec se utiliza para representar la clave privada en el formato PKCS#8, que es una especificaci�n est�ndar de la industria para la representaci�n de claves privadas.
   
  
  


  
    public static void almacenPublica(PublicKey clavePublica) throws IOException {
        //ALMAC�N DE CLAVE P�BLICA. Se guarda en un fichero .der del est�ndar X509
        try (FileOutputStream fosClavePublica = new FileOutputStream(NOM_FICH_CLAVE_PUBLICA)) {  //Se crea es Stream 
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec( //Se codifica la clave p�blica con el algoritmo RSA en el formato X.509
                    clavePublica.getEncoded(), ALGORITMO_CLAVE_PUBLICA);
            fosClavePublica.write(x509EncodedKeySpec.getEncoded());                                   //Se escribe la clave p�blica codificada sobre el fichero
            System.out.printf("Clave p�blica guardada en formato %s en fichero %s:\n%s\n",
                    x509EncodedKeySpec.getFormat(), NOM_FICH_CLAVE_PUBLICA,
                    Base64.getEncoder().encodeToString(x509EncodedKeySpec.getEncoded()).replaceAll("(.{76})", "$1\n"));  ////Esto se hace para dividir la cadena en l�neas de 76 caracteres para mejorar la legibilidad.

        } catch (IOException e) {
            System.out.println("Error de E/S escribiendo clave pública en fichero");
            throw (e);
        }
    }
    
        public static void almacenPublicaEstandar(PublicKey clavePublica) throws IOException {
        //ALMAC�N DE CLAVE P�BLICA. Se guarda en un fichero .der del est�ndar X509
        try (FileOutputStream fosClavePublica = new FileOutputStream(NOM_FICH_CLAVE_PUBLICA)) {  //Se crea es Stream 
            fosClavePublica.write(clavePublica.getEncoded());                                   //Se escribe la clave p�blica codificada sobre el fichero
            System.out.printf("Clave p�blica guardada en formato %s en fichero %s:\n%s\n",
                    clavePublica.getFormat(), NOM_FICH_CLAVE_PUBLICA,
                    Base64.getEncoder().encodeToString(clavePublica.getEncoded()).replaceAll("(.{76})", "$1\n"));  ////Esto se hace para dividir la cadena en l�neas de 76 caracteres para mejorar la legibilidad.

        } catch (IOException e) {
            System.out.println("Error de E/S escribiendo clave pública en fichero");
            throw (e);
        }
    }
  
      public static void almacenPrivada(PrivateKey clavePrivada) throws IOException {
        //ALMAC�N DE CLAVE PRIVADA. Se guarda en un fichero .pkcs8 con su correspondiente clase codificadora pkcs8EncodedKeySpec
        try (FileOutputStream fosClavePrivada = new FileOutputStream(NOM_FICH_CLAVE_PRIVADA)) {  //Se crea es Stream 
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec( //Se codifica la clave privada con el algoritmo RSA
                    clavePrivada.getEncoded(), ALGORITMO_CLAVE_PUBLICA);
            fosClavePrivada.write(pkcs8EncodedKeySpec.getEncoded());                                  //Se escribe la clave privada codificada sobre el fichero

            System.out.printf("Clave privada guardada en formato %s en fichero %s:\n%s\n", // clavePrivada.getEncoded() tiene lo mismo
                    pkcs8EncodedKeySpec.getFormat(), NOM_FICH_CLAVE_PRIVADA,
                    Base64.getEncoder().encodeToString(pkcs8EncodedKeySpec.getEncoded()).replaceAll("(.{76})", "$1\n")); //Esto se hace para dividir la cadena en l�neas de 76 caracteres para mejorar la legibilidad.
        } catch (IOException e) {
            System.out.println("Error de E/S escribiendo clave privada en fichero");
            throw (e);
        }
        

    }
      
    public static void almacenPrivadaEstandar(PrivateKey clavePrivada) throws IOException {
        //ALMAC�N DE CLAVE PRIVADA. Se guarda en un fichero .pkcs8 con su correspondiente clase codificadora pkcs8EncodedKeySpec
        try (FileOutputStream fosClavePrivada = new FileOutputStream(NOM_FICH_CLAVE_PRIVADA)) {  //Se crea es Stream 
            fosClavePrivada.write(clavePrivada.getEncoded());                                  //Se escribe la clave privada codificada sobre el fichero
            System.out.printf("Clave privada guardada en formato %s en fichero %s:\n%s\n", // clavePrivada.getEncoded() tiene lo mismo
                    clavePrivada.getFormat(), NOM_FICH_CLAVE_PRIVADA,
                    Base64.getEncoder().encodeToString(clavePrivada.getEncoded()).replaceAll("(.{76})", "$1\n")); //Esto se hace para dividir la cadena en l�neas de 76 caracteres para mejorar la legibilidad.
        } catch (IOException e) {
            System.out.println("Error de E/S escribiendo clave privada en fichero");
            throw (e);
        }

    }
    public static void main(String[] args) {

        try {
            //GENERACI�N DE LAS CLAVES
            algSeguroGenNumAleat = SecureRandom.getInstanceStrong();  // Proporciona un n�mero aleatorio de bytes

            // KeyPairGenerator: Es una clase en Java que proporciona funcionalidades para la generaci�n de pares de claves criptogr�ficas. 
            KeyPairGenerator genParClaves = KeyPairGenerator.getInstance(ALGORITMO_CLAVE_PUBLICA); //Se obtiene una instancia de un generador de par de claves
            genParClaves.initialize(TAM_CLAVE, algSeguroGenNumAleat);
            //  genParClaves.initialize(TAM_CLAVE);
            // La inicializaci�n con un generador seguro de n�meros aleatorios mejora la seguridad del proceso de generaci�n de claves.
            KeyPair parClaves = genParClaves.generateKeyPair(); //Representa un par de claves
            PublicKey clavePublica = parClaves.getPublic();
            PrivateKey clavePrivada = parClaves.getPrivate();
            almacenPublica(clavePublica);
            almacenPublicaEstandar(clavePublica);
            almacenPrivada(clavePrivada);
            almacenPrivadaEstandar(clavePrivada);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algoritmo de generaci�n de claves no soportado");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
