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
        private final byte[] hashContraseña;
        private final byte[] salt;
        private final String hashContraseñaString;

        public User(String nombre,byte[] hashContraseña, byte[] salt,String hashContraseñaString) {
            this.hashContraseña = hashContraseña;
            this.salt = salt;
            this.nombre=nombre;
            this.hashContraseñaString=hashContraseñaString;
        }

    public String getNombre() {
        return nombre;
    }

    public byte[] getHashContraseña() {
        return hashContraseña;
    }

    public String getHashContraseñaString() {
        return hashContraseñaString;
    }

    public byte[] getSalt() {
        return salt;
    }


}
