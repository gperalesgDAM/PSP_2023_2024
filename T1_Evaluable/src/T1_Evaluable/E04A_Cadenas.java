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
public class E04A_Cadenas {

    public static void main(String[] args) throws IOException {

        System.out.println("Escribre cadenas");
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        String linea = teclado.readLine();
        while (!linea.contains("*")) {

            System.out.println("Introdujiste la cadena: "+ linea);
            linea = teclado.readLine();

        }
    }
}
