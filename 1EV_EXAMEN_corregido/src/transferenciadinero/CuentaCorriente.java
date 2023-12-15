/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferenciadinero;

/**
 *
 * @author guipe
 */
    public class CuentaCorriente {

        int codigo;
        double saldo;
        double cantidad;

        public int Codigo() {
            return codigo;
        }

        public boolean haySaldoSuficiente(double cantidad) {
            return cantidad <= saldo;

        }

        public void reintegre(double cantidad) {

        }

        public void ingresar(double cantidad) {

        }

    }
