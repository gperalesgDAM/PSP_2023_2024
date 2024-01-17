/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URISyntaxException;

public class E03_URI_Con {
    public static void main(String[] args) {
        try {
            // Crear un objeto URI
            URI uri = new URI("https://es.wikipedia.org");
            // Convertir el URI a una URL
            URL url = uri.toURL();

            // Abrir una conexión a la URL
            URLConnection cn = url.openConnection();

            // Obtener el flujo de entrada para leer el contenido
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(cn.getInputStream()));

            // Leer el contenido línea por línea y mostrarlo en la consola
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
