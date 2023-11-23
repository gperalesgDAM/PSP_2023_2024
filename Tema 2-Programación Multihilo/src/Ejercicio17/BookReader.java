/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio17;


/**
 *
 * @author guipe
 */
public class BookReader implements Runnable {

    Book book;
    int orden;
    public BookReader(Book book) {
       // super();
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (book) {
            System.out.println(Thread.currentThread().getName() + " Esperando a que el libro "+ book.getTitle()+ " sea completado" );
            try {
                while (!book.isCompleted()) {
                    book.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orden= book.getOrden();
            System.out.println(Thread.currentThread().getName() + " Soy el "+orden+" en leer el libro: "+book.getTitle());
            book.incrementoOrden(orden);
            book.notify(); 
        }
    }
}
