/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.net.URL;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class E02b_URL {

    public static void main(String[] args) {
        URL url;
        try {
            // url absolutas
            url
                    = new URL("https://es.wikipedia.org/w/index.php?sort=relevance&search=Java");
            showURL(url);

            url = new URL("https://es.wikipedia.org/wiki/Java");
            showURL(url);

            url = new URL("http://docs.oracle.com");
            showURL(url);

            // url relativas
            URL baseURL = new URL("https://docs.oracle.com");
            url = new URL(baseURL, "/javase/8/docs/api/java/net/URL.html");
            showURL(url);

            baseURL = new URL("http://www.iesch.org");
            showURL(baseURL);

            url = new URL(baseURL, "/index.php/instituto/situacion");
            showURL(url);

            // constructor con distintos parámetros
            url = new URL("http", "docs.oracle.com", "/javase/8");
            showURL(url);

            // uso de caracteres especiales
            URI uri = new URI("https", "www.google.es", "/search",
                     "q=formación profesional", "");
            url = uri.toURL();
            showURL(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    // muestra el resultado de distintos métodos de la clase URL
    private static void showURL(URL url) {
        System.out.println("URL completa: " + url.toString());
        System.out.println("\tgetProtocol: " + url.getProtocol());
        System.out.println("\tgetHost: " + url.getHost());
        System.out.println("\tgetPort: " + url.getPort());
        System.out.println("\tgetFile: " + url.getFile());
        System.out.println("\tgetUserInfo: " + url.getUserInfo());
        System.out.println("\tgetPath: " + url.getPath());
        System.out.println("\tgetAuthority: " + url.getAuthority());
        System.out.println("\tgetQuery: " + url.getQuery());
        System.out.println("\tgetDefaultPort: " + url.getDefaultPort());
        System.out.println();
    }
}
