package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E00_Sumador {

    public static void main(String[] args) throws IOException {

        System.out.println("Escribe el primer número a sumar");
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
        Integer a = Integer.valueOf(teclado.readLine());
        System.out.println("Escribe otro número");
        Integer b = Integer.valueOf(teclado.readLine());
        // Calcula la suma de a y b
        Integer suma = a + b;

        // Muestra el resultado de la suma
        System.out.println("El resultado de la suma es: " + suma);

    }
}
