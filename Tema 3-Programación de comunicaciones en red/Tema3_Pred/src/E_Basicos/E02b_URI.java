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

public class E02b_URI {
    public static void main(String[] args) {
        try {
            // URL absolutas
            URI uri = new URI("https://es.wikipedia.org/w/index.php?sort=relevance&search=Java");
            showURI(uri);

            uri = new URI("https://es.wikipedia.org/wiki/Java");
            showURI(uri);

            uri = new URI("http://docs.oracle.com");
            showURI(uri);

            // URL relativas
            URI baseURI = new URI("https://docs.oracle.com");
            uri = baseURI.resolve("/javase/8/docs/api/java/net/URL.html");
            showURI(uri);

            baseURI = new URI("http://www.iesch.org");
            showURI(baseURI);

            uri = baseURI.resolve("/index.php/instituto/situacion");
            showURI(uri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // Muestra el resultado de distintos métodos de la clase URI
    private static void showURI(URI uri) {
        System.out.println("URI completa: " + uri.toString());
        System.out.println("\tgetScheme: " + uri.getScheme());
        System.out.println("\tgetHost: " + uri.getHost());
        System.out.println("\tgetPort: " + uri.getPort()); //-1 indica que utiliza el puerto por defecto
        System.out.println("\tgetPath: " + uri.getPath());
        System.out.println("\tgetUserInfo: " + uri.getUserInfo());
        System.out.println("\tgetQuery: " + uri.getQuery());
        System.out.println("\tgetAuthority: " + uri.getAuthority());
        System.out.println("\tgetFragment: " + uri.getFragment());
        System.out.println();
    }
}
