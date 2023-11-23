/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio17;


/**
 *
 * @author guipe
 */
// It is the common java class on which thread will act and call wait and notify method.
public class Book {

    //Atributos
    private String title;
    private boolean isCompleted = false;
    private boolean isFirstReader = false;
    private int orden = 1;
    private int lectores;

    //Constructores
    public Book(String title) {
        //super();
        this.title = title;
    }

    //Medodos
    public String getTitle() {
        return title;
    }

    public int getLectores() {
        return lectores;
    }

    public void setLectores(int lectores) {
        this.lectores = lectores;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean firstReader() {
        return isFirstReader;
    }

    public void setFirstReader(boolean isFirstReader) {
        this.isFirstReader = isFirstReader;
    }

    public void incrementoOrden(int orden) {
        this.orden = orden + 1;
    }

    public int getOrden() {
        return orden;
    }

}
