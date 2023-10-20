/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author guipe
 */
public class A01_Hilo extends Thread {

    
    
    //Variables

    //Constructores
    A01_Hilo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        
        System.out.println("Hola mundo, soy el hilo "+Thread.currentThread().getName()+ " con Id: " + Thread.currentThread().getId());
    }
        
    }

