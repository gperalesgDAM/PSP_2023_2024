/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guipe
 */
public class E03_Hijo {
    

    public static void main(String[] args) {
        // Solicitar una cadena de texto al usuario
        System.out.println("Está en el proceso hijo, ingrese una cadena de texto:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String entrada="";
        try {
            entrada = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(E03_Hijo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Imprimir la entrada capturada
        System.out.println("Ha ingresado: " + entrada +" en el proceso hijo");
        System.out.println("Proceso hijo finalizado");
    }
}

    

