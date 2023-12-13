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
import java.net.MalformedURLException;
import java.net.URL;

public class E02d_URL {

    public static void main(String[] args) {

        try {
            // creamos el objeto url
            URL url = new URL("https://es.wikipedia.org");
            // abrimos un reader que lee directamente de la url y lo envolvemos en un buffered reader para leerlo linea a linea
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            // recorremos el reader y lo mostramos por consola
            String line;
            //Esto continúa hasta que no hay más líneas para leer (cuando readLine() devuelve null).
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
