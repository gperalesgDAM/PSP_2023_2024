/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3;

/**
 *
 * @author guipe
 */

import com.api.clases.PersonaRequest;
import com.api.clases.PersonaResponse;
import com.api.clases.Persona;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController //Indicamos el controlador Rest
//@RequestMapping("/api") 
//http://localhost:8080/demo/ //Ruta de arranque
public class Controller {

    private final List<Persona> personas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping("/")
    @ResponseBody  //Estás indicando que el valor devuelto por el método debe tratarse como el cuerpo de la respuesta
    public String welcome() {
        return "¡Hola desde la aplicación Spring Boot!";
    }

    @PostMapping("/consulta")
    //http://localhost:8080/demo/consulta
    public ResponseEntity<String> consulta(@RequestBody PersonaRequest request) {
        String nombre = request.getNombre();
        long id = idGenerator.getAndIncrement();
        personas.add(new Persona(id, nombre));
        String mensaje = "¡Hola " + (nombre != null ? nombre : "anónimo") + ", eres el ID " + id + "!";
        PersonaResponse response = new PersonaResponse(id, nombre, mensaje);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> obtenerPersonas() {
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id) {
        for (Persona p : personas) {
            if (p.getId() == id) {
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<String> modificarNombrePersona(@PathVariable long id, @RequestBody PersonaRequest request) {
        Persona personaEncontrada = null;

        for (Persona persona : personas) {
            if (persona.getId() == id) {
                personaEncontrada = persona;
                break;
            }
        }

        if (personaEncontrada != null) {
            personaEncontrada.setNombre(request.getNombre());
            return new ResponseEntity<>("Nombre modificado correctamente para la persona con ID " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró ninguna persona con la ID " + id, HttpStatus.NOT_FOUND);
        }
    }
}
