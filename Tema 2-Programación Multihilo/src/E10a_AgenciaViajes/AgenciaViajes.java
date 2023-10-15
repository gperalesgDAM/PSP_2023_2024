/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E10a_AgenciaViajes;

/**
 *
 * @author guipe
 */
public class AgenciaViajes implements Runnable {

 private AsientoAvion sa = new AsientoAvion();

 @Override
 public void run(){
   gestionAsientoAvion(3);
   if(sa.getAsientosLibres()<=0)
     System.out.println("No hay asientos libres");
 }

 public void gestionAsientoAvion(int numAsientosReserva){
   
   //Comprobamos si hay asientos libres
   if(sa.getAsientosLibres()>=numAsientosReserva)
   {
     System.out.println(Thread.currentThread().getName()+
                     " hará una reserva de "+ numAsientosReserva +" plazas");
     try {
       Thread.sleep(1000);
     }
     catch (InterruptedException ex) {}

     //Hacemos la reserva de los asientos
     sa.reservaAsientos(numAsientosReserva);
     System.out.println(Thread.currentThread().getName() + 
                        " Reserva realizada con éxito."+
                        " Las plazas libres son "+sa.getAsientosLibres());
   }else{
     System.out.println("No hay plazas suficientes para el cliente." + 
                         Thread.currentThread().getName()+
                        " Las plazas libres son: "+sa. getAsientosLibres ());
     try {
       Thread.sleep(1000);
     }
     catch (InterruptedException ex) {}
   }
 }


 public static void main(String[] args) {

   AgenciaViajes objAg = new AgenciaViajes ();
   
   //Creamos dos hilos sobre la misma instancia
   Thread hilo1 = new Thread(objAg);
   Thread hilo2 = new Thread(objAg);
   hilo1.setName("Cliente 1");
   hilo2.setName("Cliente 2");

   hilo1.start();
   hilo2.start();
  }
 }


