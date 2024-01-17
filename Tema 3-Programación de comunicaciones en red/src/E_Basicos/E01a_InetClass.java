package E_Basicos;

import java.net.*;

public class E01a_InetClass {


    public static void main(String[] args) {

        InetAddress dir1 = null;
        InetAddress dir2 = null;
        System.out.println("======================");
        System.out.println("Salida para localhost");

        try {

            //Localhost
            dir1 = InetAddress.getByName("localhost");
            pruebaMetodos(dir1);

            System.out.println("======================");
            System.out.println("Salida para una URL");
            //www.google.es==> Probar con www.youtube.com para mostrar varias Ips
            dir2 = InetAddress.getByName("www.google.com");
            pruebaMetodos(dir2);

            //Array de tipo InetAddress
            InetAddress[] direcciones = InetAddress.getAllByName(dir2.getHostName());
            System.out.println("Direcciones para " + dir2.getHostName()+ ": " + direcciones.length);
            for (int i = 0; i < direcciones.length; i++) {

                System.out.println(direcciones[i].toString());
            }

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {

        System.out.println("Método getByName: " + dir);
        //usamos métodos de la clase
        System.out.println("Método getLocalHost: " + dir.getHostName());
        System.out.println("Método getHostAddress: " + dir.getHostAddress());
        System.out.println("Método toString: " + dir.toString());
        System.out.println("Método getCononicalHostName: " + dir.getCanonicalHostName());
    }

}
