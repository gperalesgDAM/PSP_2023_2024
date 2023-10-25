/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8a;

/**
 *
 * @author guipe
 */
public class Principal {

    public static void main(String[] args) {

        String nombre = "";
        String mensaje = "";
        for (int i = 0; i < 5; i++) {
            nombre = "hilo_" + (i + 1);
            mensaje = "mensaje_" + (i + 1);

            Hilo h = new Hilo(mensaje);
            Thread thread = new Thread(h,nombre);
            //thread.setName(nombre);
            thread.start(); //iniciar hilo

        }

    }

}
