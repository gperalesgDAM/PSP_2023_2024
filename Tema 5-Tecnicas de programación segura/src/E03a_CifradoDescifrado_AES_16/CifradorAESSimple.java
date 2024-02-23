/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E03a_CifradoDescifrado_AES_16;


import java.io.PrintWriter;
import java.security.Key;


/**
 *
 * @author guipe
 */
public class CifradorAESSimple {

    public static void main(String[] args) {

        final String NOMBRE_FICHERO = "./archivos/mensaje_cifrado.txt";
        final String PASSWORD = "0123456789124567";
        final String TEXTO_EN_CLARO = "La clave secreta de la caja fuerte es 3842873110";
        final int LONGITUD = 16; //Expresado en bytes 
        try {

            Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD);
            String textoEnClaro = TEXTO_EN_CLARO;
            String textoCifrado = AESSimpleManager.cifrar(textoEnClaro, clave);
            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifrado);
            pw.close();
            System.out.println("El mensaje se ha cifrado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
