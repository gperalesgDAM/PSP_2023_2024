/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciadinero;

/**
 *
 * @author guipe
 */
public class EvitarInterbloqueo {

    public static void transferenciaDinero(CuentaCorriente cuentaOrigen, CuentaCorriente cuentaDestino, double cantidad) {

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

    public static void main(String[] args) {
        CuentaCorriente cuenta2100 = new CuentaCorriente();
        CuentaCorriente cuenta8888 = new CuentaCorriente();
        double cantidad1 = 0;
        double cantidad2 = 0;
        Hilo transferenciaDinero1 = new Hilo(cuenta2100, cuenta8888, cantidad1);
        Hilo transferenciaDinero2 = new Hilo(cuenta8888, cuenta2100, cantidad2);
        transferenciaDinero1.start();
        transferenciaDinero2.start();

    }
}
