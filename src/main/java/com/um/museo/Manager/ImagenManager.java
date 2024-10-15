package com.um.museo.Manager;

import com.um.museo.Model.Imagen;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ImagenManager {
    
    Mono<Imagen> saveImagen(Imagen imagen);

    Mono<Imagen> getImagen(Long id);

    Mono<Imagen> deleteImagen(Long id);
}
