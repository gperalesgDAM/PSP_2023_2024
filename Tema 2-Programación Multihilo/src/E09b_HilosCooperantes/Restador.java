/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09b_HilosCooperantes;

/**
 *
 * @author guipe
 */
public class Restador implements Runnable {
  private Contador c;
  private String name;
  public Restador(String name, Contador c) {
    // Restador doesn't extend Thread, so it cannot call the Thread constructor
    // super(name);
    this.name = name;
    this.c = c;    
  }
  
  @Override
  public void run() {
    Thread.currentThread().setName(this.name);
    // Ejecutar 300 veces con espera entre 50ms y 150ms
    for (int i = 0; i < 300; i++) {      
      try {
        c.decrementa();
        System.out.println(Thread.currentThread().getName() + " " + c.valor());              
        Thread.sleep((long) (Math.random() * 100 + 50));
      } catch (InterruptedException ex) {
        // Nothing
      }      
    }    
  }
}
