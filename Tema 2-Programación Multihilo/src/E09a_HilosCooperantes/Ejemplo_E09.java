/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09a_HilosCooperantes;

/**
 *
 * @author guipe
 */
public class Ejemplo_E09 {

    public static void main(String[] argv) throws Exception {
       while (true){
        final int M = 200;
        Thread t[] = new Thread[M];
        for (int i = 0; i < M; i++) {
            t[i] = new Incrementador();
        }
        for (int i = 0; i < M; i++) {
            t[i].start();
        }
        for (int i = 0; i < M; i++) {
            t[i].join();
        }
        System.out.println(Incrementador.n);
    }
    }
}

class Incrementador extends Thread {
    // Si no es static cada objeto tendría su propia n

    final private static int N = 10;
    static int n = 0;

    @Override
    public void run() {
        for (int i = 0; i < N; i++) {
            n++;
        }
    }
}

