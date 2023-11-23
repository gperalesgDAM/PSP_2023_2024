/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio17;
import java.util.Scanner;

/**
 *
 * @author guipe
 */
// This is our main class which will create object of above classes and run it.
public class ThreadInterCommunicationMain {

    public static void main(String args[]) {
        int lectores = 0;

        System.out.println("¿Cual será el título del libro?");

        Scanner lector1 = new Scanner(System.in);
        String titulo = lector1.nextLine();

        System.out.println("¿Cuantas personas quieren leer el libro?");
        Scanner lector2 = new Scanner(System.in);
        lectores = (int) lector2.nextInt();



// Book object on which wait and notify method will be called
        Book book = new Book(titulo);
        Thread[] threads = new Thread[lectores];
        for (int i = 0; i < lectores; i++) {
            threads[i] = new Thread(new BookReader(book));
            threads[i].setName("Lector_" + (i + 1));
            threads[i].start();
        }
        // To ensure all readers started waiting for the book
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // BookWriter thread which will notify once book get completed
        BookWriter bookWriter = new BookWriter(book);
        Thread bookWriterThread = new Thread(bookWriter);
        bookWriterThread.start();
        
        try {
            for (int i = 0; i < lectores; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los lectores han leido el libro");
    }
}
