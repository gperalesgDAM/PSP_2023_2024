/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package E_Interbloqueo_transferenciadinero;

/**
 *
 * @author guipe
 */
public class TransferenciaDinero {

    /**
     * @param args the command line arguments
     */
    public void transferenciaDinero(CuentaCorriente cuentaOrigen, CuentaCorriente cuentaDestino, double cantidad) {
        synchronized (cuentaOrigen) {
            synchronized (cuentaDestino) {
                if (cuentaOrigen.haySaldoSuficiente(cantidad)) {
                    cuentaOrigen.reintegre(cantidad);
                    cuentaDestino.ingresar(cantidad);
                }
            }
        }

    }

    //transferenciaDinero(cuenta2100, cuenta8888, cantidad1);
}
