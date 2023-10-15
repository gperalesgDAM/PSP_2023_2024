/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E10a_AgenciaViajes;

/**
 *
 * @author guipe
 */
 class AsientoAvion {
   
   private int asientosLibres = 5;
   
   public int getAsientosLibres(){
     return asientosLibres;
   }

   public boolean getAsientosLibres(int numPlazas){
     if (numPlazas <= asientosLibres)
       return true;
     else
       return false;
   }

   public void reservaAsientos(int numAsientosReserva){
     asientosLibres = asientosLibres - numAsientosReserva;
   }

 }
