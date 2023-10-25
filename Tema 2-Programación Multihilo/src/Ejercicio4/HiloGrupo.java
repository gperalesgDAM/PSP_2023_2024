package Ejercicio4;


public class HiloGrupo extends Thread {

    @Override
    public void run() {

        System.out.println("Datos del Hilo: " + Thread.currentThread().toString());

    }

}
