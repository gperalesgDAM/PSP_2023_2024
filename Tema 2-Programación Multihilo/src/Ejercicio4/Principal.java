package Ejercicio4;

public class Principal {

    public static void main(String[] args) {

        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        ThreadGroup grupo1 = new ThreadGroup("subgrupo 1");
        HiloGrupo h = new HiloGrupo();
        Thread h1 = new Thread(grupo1, h, "hilo1");
        Thread h2 = new Thread(grupo1, h, "hilo2");
        h1.start();
        h2.start();

        ThreadGroup grupo2 = new ThreadGroup("subgrupo 2");
        Thread h3 = new Thread(grupo2, h, "hilo3");
        h3.start();

    }

}
