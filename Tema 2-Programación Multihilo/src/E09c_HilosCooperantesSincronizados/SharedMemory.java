/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09c_HilosCooperantesSincronizados;


/**
 *
 * @author guipe
 */
public class SharedMemory {
  public static void main(String[] args) throws InterruptedException {
    // Inicializar el objeto Contador2
    Contador2 c = new Contador2(100);
    
    // Crear y lanzar 2 hilos (Sumador + Restador)
    Sumador s1 = new Sumador("Sumador1", c);
    Restador r1 = new Restador("Restador1", c);
    Thread h1 = new Thread(r1);
    
    s1.start();
    h1.start();
    
    // El hilo principal espera a que los hilos s1 y r1 terminen
    s1.join();
    h1.join();
    
    System.out.println("El valor final de c es " + c.valor());
    
  }
}
