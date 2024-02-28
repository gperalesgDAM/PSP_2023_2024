/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad1;

/**
 *
 * @author guipe
 */
    public class User {
        private final String nombre;
        private final byte[] hashContrase�a;
        private final byte[] salt;

        public User(String nombre,byte[] hashContrase�a, byte[] salt) {
            this.hashContrase�a = hashContrase�a;
            this.salt = salt;
            this.nombre=nombre;
        }

    public String getNombre() {
        return nombre;
    }

    public byte[] getHashContrase�a() {
        return hashContrase�a;
    }


    public byte[] getSalt() {
        return salt;
    }


}
