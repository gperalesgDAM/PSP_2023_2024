/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.clases;

public class PersonaResponse {
    private final long id;
    private final String nombre;
    private final String mensaje;

    public PersonaResponse(long id, String nombre, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }
}
