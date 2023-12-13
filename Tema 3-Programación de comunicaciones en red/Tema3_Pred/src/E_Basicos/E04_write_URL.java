/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

public class E04_write_URL {

    public static void main(String[] args) {
        try {
            // dirección del recurso
            URL url1 = new URL("https://httpbin.org/post");
            URI uri = new URI("https://httpbin.org/post");
            // Convertir el URI a una URL
            URL url2 = uri.toURL();
            URL url = url2;  //Para comprobar con ambos modos de crear la url
            // creamos una conexión
            HttpsURLConnection httpClient = (HttpsURLConnection) url.openConnection();

            // establecemos el método de la petición
            httpClient.setRequestMethod("POST");

            //creamos una cadena con los parámetros de la petición
            String urlParameters = "custname=Guillermo"
                    + "&custemail=c@c.com"
                    + "&custtel=666666666"
                    + "&delivery=22:30"
                    + "&size=mediana"
                    + "&topping=extra de queso&topping=cebolla"
                    + "&comments=Traer bien caliente";

            // enviamos la petición POST
            httpClient.setDoOutput(true);
            try (PrintWriter wr = new PrintWriter(httpClient.getOutputStream())) {
                wr.write(urlParameters);
                wr.close();
            }

            // obtenemos la respuesta del servidor
            int responseCode = httpClient.getResponseCode();
            System.out.println("Sending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response:");
            // imprimimos la respuesta
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

            }
            httpClient.disconnect();

        } catch (MalformedURLException | URISyntaxException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
