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
        private final String hashContrase�aString;

        public User(String nombre,byte[] hashContrase�a, byte[] salt,String hashContrase�aString) {
            this.hashContrase�a = hashContrase�a;
            this.salt = salt;
            this.nombre=nombre;
            this.hashContrase�aString=hashContrase�aString;
        }

    public String getNombre() {
        return nombre;
    }

    public byte[] getHashContrase�a() {
        return hashContrase�a;
    }

    public String getHashContrase�aString() {
        return hashContrase�aString;
    }

    public byte[] getSalt() {
        return salt;
    }


}
