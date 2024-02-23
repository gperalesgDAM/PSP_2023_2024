/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E01_InfoProveedoresJCA;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;
import java.util.Set;

/**
 *
 * @author guipe
 Las propiedades del proveedor se refieren a configuraciones y detalles específicos del proveedor de seguridad
Cada proveedor de seguridad en Java puede proporcionar implementaciones para varios algoritmos criptográficos, 
protocolos de seguridad, generadores de números aleatorios, entre otros servicios relacionados con la seguridad.
 */
class InfoProveedoresJCA {

    public static void main(String[] args) {
        boolean listarProps = false;
//        if (args.length > 0 && args[0].equals("-l")) {
//            listarProps = true;
//        }
        System.out.println("------------------------------------");
        System.out.println("Proveedores instalados en su sistema");
        System.out.println("------------------------------------");
        int i = 0;
        for (Provider proveedor : Security.getProviders()) {
            System.out.println("Núm. proveedor : " + (i + 1));
            System.out.println("Nombre         : " + proveedor.getName());
            System.out.println("Versión        : " + proveedor.getVersion());
            System.out.println("Información    : " + proveedor.getInfo());
            System.out.println("Servicios    :\n");
            Set<Provider.Service> servicios = proveedor.getServices();
            for (Provider.Service servicio : servicios) {
                //Se filtran los servicios por el tipo
                System.out.println("El algoritmo " + servicio.getAlgorithm() + " es de tipo " + servicio.getType());
            }
            System.out.println("Propiedades    :");
            i++;
            if (listarProps) {
                Enumeration propiedades = proveedor.propertyNames();
                while (propiedades.hasMoreElements()) {
                    String clave = (String) propiedades.nextElement();
                    String valor = proveedor.getProperty(clave);
                    System.out.println("  " + clave + " = " + valor);
                }
            }
            System.out.println("------------------------------------");
        }
    }
}
