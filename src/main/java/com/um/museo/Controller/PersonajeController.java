package com.um.museo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.museo.Manager.PersonajeManager;
import com.um.museo.Model.Edificio;
import com.um.museo.Model.Personaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {

    @Autowired
    private PersonajeManager personajeManager;

    @PostMapping()
    public Mono<Personaje> saveEdificio(@RequestBody Personaje personaje) {
        return personajeManager.savePersonaje(personaje);
    }

    @DeleteMapping("/{id}")
    private Mono<Personaje> deleteEdificio(@PathVariable Long id) {
        return personajeManager.removePersonaje(id);
    }

    @GetMapping("/{id}")
    public Mono<Personaje> getPersonaje(@PathVariable Long id) {
        return personajeManager.getPersonaje(id);
    }

    @GetMapping()
    public Flux<Personaje> getPersonajes() {
        return personajeManager.getPersonajes();
    }
}
