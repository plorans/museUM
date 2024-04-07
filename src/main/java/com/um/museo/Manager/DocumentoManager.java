package com.um.museo.Manager;

import com.um.museo.Model.Documento;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentoManager {
    
    Mono<Documento> saveDocumento(Documento documento);

    Flux<Documento> getDocumentos();

    Mono<Documento> getDocumento(Long id);

    Mono<Documento> deleteDocumento(Long id);
    
}
