/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author guipe
 */
public class E02c_URL {
    //URLDemo.java  

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("\t======================");
        System.out.println("\tRESULTADOS CON URL");
        System.out.println("\t======================");
        URL url = new URL("https://www.google.com/search?q=javatpoint&oq=javatpoint&sourceid=chrome&ie=UTF-8");


        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host Name: " + url.getHost());
        System.out.println("Port Number: " + url.getPort());
        System.out.println("Default Port Number: " + url.getDefaultPort());
        System.out.println("Query String: " + url.getQuery());
        System.out.println("Path: " + url.getPath());
        System.out.println("File: " + url.getFile());

        System.out.println("\t======================");
        System.out.println("\tRESULTADOS CON URI");
        System.out.println("\t======================");

        try {
            URI uri = new URI("https://www.google.com/search?q=javatpoint&oq=javatpoint&sourceid=chrome&ie=UTF-8");

            System.out.println("Protocol: " + uri.getScheme());
            System.out.println("Host Name: " + uri.getHost());
            System.out.println("Port Number: " + uri.getPort());
            System.out.println("Default Port Number: URI no tiene metodo equivalente para obtener puerto por defecto");
            System.out.println("Query String: " + uri.getQuery());
            System.out.println("Path: " + uri.getPath());
            System.out.println("File: " + uri.getPath()); // En URI, getFile() devuelve la parte del path y no del path completo
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
