package com.um.museo.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.DocumentoDao;
import com.um.museo.Manager.DocumentoManager;
import com.um.museo.Model.Documento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("DocumentoManager")
public class DocumentoManagerImpl implements DocumentoManager {

    @Autowired
    private DocumentoDao documentoDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Mono<Documento> saveDocumento(Documento documento) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(documento);
            transaction.commit();
            return Mono.just(documento);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    @Override
    public Flux<Documento> getDocumentos() {
        return Flux.fromIterable(documentoDao.findAll());
    }

    @Override
    public Mono<Documento> getDocumento(Long id) {
        return Mono.fromSupplier(() -> documentoDao.findById(id).orElse(null));
    }

    @Transactional
    @Override
    public Mono<Void> deleteDocumento(Long id) {
        return Mono.fromRunnable(() -> {
            EntityTransaction transaction = null;
            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                Documento documento = entityManager.find(Documento.class, id);
                if (documento != null) {
                    entityManager.remove(documento);
                    transaction.commit();
                }
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        });
    }

}
