package Ejem07b_TCP_Object;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre;
    int edad;
    boolean ultima;

    public Persona(String nombre, int edad, boolean ultima) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.ultima = ultima;
    }
    
        public Persona(String nombre, int edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isUltima() {
        return ultima;
    }
    
    
}
