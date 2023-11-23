/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio17;



/**
 *
 * @author guipe
 */
// This class will notify thread(in case of notify) which is waiting on book object. 
// It will not give away lock as soon as notify is called, it first complete its synchronized block. 
// So in this example, BookWriter will complete the book and notify it to BookReaders. 
public class BookWriter implements Runnable {

    Book book;

    public BookWriter(Book book) {
        // super();
        this.book = book;
    }

    @Override
    public void run() {

        System.out.println("El autor acaba de empezar a escribir el libro : " + book.getTitle());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        book.setCompleted(true);
        System.out.println("El libro ya ha sido escrito");
        synchronized (book) {
            book.notify();
            System.out.println("Se notifica al primer lector");
        }
    }
}
