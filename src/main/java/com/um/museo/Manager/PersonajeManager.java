package com.um.museo.Manager;

import com.um.museo.Model.Personaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonajeManager {
   
    Mono<Personaje> savePersonaje(Personaje personaje);

    Flux<Personaje> getPersonajes(Personaje personaje);

    Mono<Personaje> getPersonaje(Long id);

    Mono<Personaje> removePersonaje(Personaje personaje);
}
