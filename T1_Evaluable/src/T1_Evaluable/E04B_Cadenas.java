/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T1_Evaluable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guipe
 */
public class E04B_Cadenas {

    public static void comprobarPalidromo(String linea) {

        int ini = 0;
        int fin = linea.length() - 1;
        boolean esPalidromo = true;
        while (ini < fin && esPalidromo) {
            if (linea.charAt(ini) != linea.charAt(fin)) {
                esPalidromo = false;
            }
            ini++;
            fin--;
        }
        if (esPalidromo) {
            System.out.println(linea + " es palidromo");
        } else {
            System.out.println(linea + " no es palidromo");
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Escribre cadenas");
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        String linea = teclado.readLine();
        while (!linea.contains("*")) {

            comprobarPalidromo(linea);
            linea = teclado.readLine();

        }
    }
}
