/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciadinero;

/**
 *
 * @author guipe
 */


public class Hilo extends Thread {
CuentaCorriente cuentaOrigen;
CuentaCorriente cuentaDestino;
 double cantidad;
    Hilo(CuentaCorriente cuentaOrigen, CuentaCorriente cuentaDestino, double cantidad) {
       this.cuentaOrigen=  cuentaOrigen;
       this.cuentaDestino=  cuentaDestino;
       this.cantidad=  cantidad;
    }
  
      
    
    @Override
    public void run() {
        
        EvitarInterbloqueo.transferenciaDinero(cuentaOrigen, cuentaDestino, cantidad);
        
    }
}
