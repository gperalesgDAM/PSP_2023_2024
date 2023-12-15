package Ejercicio2;

class Coches extends Thread {

    private int id;
    private Puestos puesto;
    private int tiempoLlegada;
    private String nombre;

    Coches(int id, Puestos puesto, int tiempoLlegada) {
        this.id = id;
        this.puesto = puesto;
        this.tiempoLlegada = tiempoLlegada;
        nombre = "Coche_" + id;
    }

    public int getIdCliente() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        try {
            System.out.println(nombre + " en el sistema");
            Thread.sleep(tiempoLlegada);
            //System.out.println("Coche " + id + " entrará al lavadero al puesto " + puesto.getNombre() );
            long s = System.currentTimeMillis(); //Tiempo Unix en ms desde 1970
            puesto.productor(this);
            Thread.sleep(100); //El coche está siendo lavado
            puesto.consumidor(this);
            long espera = System.currentTimeMillis() - s;
            puesto.IncrementoTiempoEsperaAcumulado(espera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
