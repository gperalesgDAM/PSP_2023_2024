/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_Interbloqueo_transferenciadinero;

/**
 *
 * @author guipe
 */

public class EvitarInterbloqueo {

    public void transferenciaDinero(CuentaCorriente cuentaOrigen, CuentaCorriente cuentaDestino, double cantidad) {
        CuentaCorriente primeraCuenta;
        CuentaCorriente segundaCuenta;

        if (cuentaOrigen.Codigo() < cuentaDestino.Codigo()) {
            primeraCuenta = cuentaOrigen;
            segundaCuenta = cuentaDestino;
        } else {
            primeraCuenta = cuentaDestino;
            segundaCuenta = cuentaOrigen;
        }

        synchronized (primeraCuenta) {
            synchronized (segundaCuenta) {
                if (cuentaOrigen.haySaldoSuficiente(cantidad)) {
                    cuentaOrigen.reintegre(cantidad);
                    cuentaDestino.ingresar(cantidad);
                }
            }
        }
    }
}

