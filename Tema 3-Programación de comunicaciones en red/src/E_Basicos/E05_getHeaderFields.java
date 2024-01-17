/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Basicos;

/**
 *
 * @author guipe
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class E05_getHeaderFields {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.iesch.org");
            //URL url = new URL("https://www.marca.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Realizar la conexión
            connection.connect();

            // Obtener las cabeceras
            Map<String, List<String>> cabeceras = connection.getHeaderFields();

            // Iterar sobre las cabeceras e imprimirlas
            for (Map.Entry<String, List<String>> entry : cabeceras.entrySet()) {
                String nombreCabecera = entry.getKey();
                List<String> valores = entry.getValue();

                if (nombreCabecera != null) {
                    System.out.println(nombreCabecera + ":");
                    for (String valor : valores) {
                        System.out.println("\t" + valor);
                    }
                }
            }

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
