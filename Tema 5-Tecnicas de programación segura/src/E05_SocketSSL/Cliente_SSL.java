/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package E05_SocketSSL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author guipe
 */
public class Cliente_SSL
{

    public static void main(String[] arg) throws IOException {

        SSLSocket clienteSSL = null;
        DataInputStream flujoEntrada = null; //FLUJO DE ENTRADA DE CLIENTE
        DataOutputStream flujoSalida = null; //FLUJO DE SALIDA AL CLIENTE

        // Las propiedades se pueden especificar mediante código, o bien mediante
        // argumentos de la JVM en la llamada a la aplicación
        String ruta1 = System.getProperty("user.dir") + "\\archivos\\certificados\\clavescliente";
       // String ruta2 = "C:\\Users\\guipe\\OneDrive\\Documentos\\NetBeansProjects\\PSP\\PSP_Tema_5\\Tema5_TecnicasPS\\archivos\\certificados\\clavescliente";
        //System.setProperty("javax.net.ssl.keyStore", ruta);
        System.setProperty("javax.net.ssl.trustStore", ruta1);
        //System.setProperty("javax.net.ssl.trustStore", System.getProperty("user.dir") + "\\archivos\\certificados\\clavescliente");    
        System.setProperty("javax.net.ssl.trustStorePassword", "87654321");

        
        // Inicialización del ServerSocket SSL
        int puerto = 6000;
        String host = "localhost";

        System.out.println("Programa Cliente iniciado....");
        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        clienteSSL = (SSLSocket) sfact.createSocket(host, puerto);

        // Trabajamos do DataInputStream y DataOutputStream para simplificar
        // el código del ejemplo
        flujoSalida = new DataOutputStream(clienteSSL.getOutputStream());
        flujoEntrada = new DataInputStream(clienteSSL.getInputStream());

        // Envío un saludo al servidor
        flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

        // El Servidor responde con un mensaje
        System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());

        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        clienteSSL.close();
    }

    void mostrarInformacionSesionSSL(SSLSocket cliente) throws SSLPeerUnverifiedException {

        //------------------------------------------------------------------------------
        //Ejemplo de la múltiple información sobre la sesión SSL
        // que se puede obtener a partir 
        SSLSession session = ((SSLSocket) cliente).getSession();
        System.out.println("Host: " + session.getPeerHost());
        System.out.println("Cifrado: " + session.getCipherSuite());
        System.out.println("Protocolo: " + session.getProtocol());

        System.out.println("IDentificador:" + new BigInteger(session.getId()));

        System.out.println("Creación de la sesión: " + session.getCreationTime());

        X509Certificate certificate = (X509Certificate) session.getPeerCertificates()[0];
        System.out.println("Propietario: " + certificate.getSubjectDN());
        System.out.println("Algoritmo: " + certificate.getSigAlgName());
        System.out.println("Tipo: " + certificate.getType());
        System.out.println("Emisor: " + certificate.getIssuerDN());
        System.out.println("Número Serie: " + certificate.getSerialNumber());
        //-----------------------------------------------------------------------------
    }
}

