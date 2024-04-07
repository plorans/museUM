package com.um.museo.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.DocumentoDao;
import com.um.museo.Manager.DocumentoManager;
import com.um.museo.Model.Documento;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("DocumentoManager")
public class DocumentoManagerImpl implements DocumentoManager {

    @Autowired
    private DocumentoDao documentoDao;

    @Override
    public Mono<Documento> saveDocumento(Documento documento) {
        return Mono.just(documentoDao.save(documento));
    }

    @Override
    public Flux<Documento> getDocumentos() {
        return Flux.fromIterable(documentoDao.findAll());
    }

    @Override
    public Mono<Documento> getDocumento(Long id) {
        return Mono.fromSupplier(() -> documentoDao.findById(id).orElse(null));
    }

    @Override
    public Mono<Documento> deleteDocumento(Long id) {
        return Mono.fromCallable(() -> {
            Documento deletedDocumento = documentoDao.findById(id).orElseThrow(() -> new NotFoundException());

            documentoDao.deleteById(id);

            return deletedDocumento;
        });
    }

}
