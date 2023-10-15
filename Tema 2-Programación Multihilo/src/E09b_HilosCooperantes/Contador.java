/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09b_HilosCooperantes;

/**
 *
 * @author guipe
 */
public class Contador {
  private int c = 0;
  
  public Contador(int c) {
    this.c = c;
  }
  
  public void incrementa() {
    c++;
  }
  public void decrementa() {
    c--;
  }
  
  public int valor() {
    return c;
  }
}
