package com.um.museo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.museo.Manager.DocumentoManager;
import com.um.museo.Model.Documento;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    
    @Autowired
    private DocumentoManager documentoManager;

    @PostMapping()
    public Mono<Documento> saveDocumento(Documento documento) {
        return documentoManager.saveDocumento(documento);
    }

    @DeleteMapping("/{id}")
    private Mono<Void> deleteDocumento(@PathVariable Long id){
        return documentoManager.deleteDocumento(id);
    }

    @GetMapping("/{id}")
    public Mono<Documento> getDocumento(@PathVariable Long id){
        return documentoManager.getDocumento(id);
    }

    @GetMapping()
    public Flux<Documento> getDocumentos(){
        return documentoManager.getDocumentos();
    }
}
