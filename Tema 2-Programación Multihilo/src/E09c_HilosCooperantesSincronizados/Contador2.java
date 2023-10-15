/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09c_HilosCooperantesSincronizados;


/**
 *
 * @author guipe
 */
public class Contador2 {
  private int c = 0;
  
  public Contador2(int c) {
    this.c = c;
  }
  
  public synchronized void incrementa() {
    c++;
  }
  public synchronized void decrementa() {
    c--;
  }
  
  public int valor() {
    return c;
  }
}
