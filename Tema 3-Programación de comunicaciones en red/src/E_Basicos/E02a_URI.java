/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.net.URI;
import java.net.URISyntaxException;

public class E02a_URI {

    public static void main(String[] args) {
        try {
            String urlString = "https://www.google.com/search?q=java";

            // Crear un objeto URI a partir de la cadena URL
            URI uri = new URI(urlString);

            // Obtener los valores del URI
            String scheme = uri.getScheme();
            String authority = uri.getAuthority();
            String path = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            boolean isAbsolute = uri.isAbsolute();
            boolean isOpaque = uri.isOpaque();

            // Imprimir los valores obtenidos del URI
            System.out.println("Scheme: " + scheme);
            System.out.println("Authority: " + authority);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Fragment: " + fragment);
            System.out.println("Is Absolute: " + isAbsolute);
            System.out.println("Is Opaque: " + isOpaque);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
