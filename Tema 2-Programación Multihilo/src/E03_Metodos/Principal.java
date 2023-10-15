package E03_Metodos;

public class Principal {

    public static void main(String[] args) {

        Thread.currentThread().setName("principal"); //nombre del main
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
        //Devuelve Thread[#1,principal,5,main]:
        //      #1: Identificador unico asignado al hilo
        //      principal: nombre del hilo
        //      5: Prioridad por defecto de un hilo (entre 1 la mas baja-10 la m√°s alta)
        //      main: Grupo de hilos al que pertenece
        Hilo h = null;
        for (int i = 0; i < 3; i++) {
            h = new Hilo();
            h.setName("HILO" + i);
            h.setPriority(i + 1);
            h.start();

            System.out.println("InformaciÛn del " + h.getName() + " : " + h.toString());
            System.out.println("3 hilos creados");
            System.out.println("hilos activos: " + Thread.activeCount());
        }

    }

}
