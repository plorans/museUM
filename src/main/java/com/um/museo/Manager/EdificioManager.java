package com.um.museo.Manager;

import com.um.museo.Model.Edificio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EdificioManager {
    Mono<Edificio> saveEdificio(Edificio edificio);

    Flux<Edificio> getEdificios();

    Mono<Edificio> getEdificio(Long id);

    Mono<Edificio> deleteEdificio(Long id);
}
