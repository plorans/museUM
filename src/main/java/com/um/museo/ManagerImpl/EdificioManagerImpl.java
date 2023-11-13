package com.um.museo.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.EdificioDao;
import com.um.museo.Manager.EdificioManager;
import com.um.museo.Model.Edificio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("EdificioManager")
public class EdificioManagerImpl implements EdificioManager {

    @Autowired
    private EdificioDao edificioDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Mono<Edificio> saveEdificio(Edificio edificio) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(edificio);
            transaction.commit();
            return Mono.just(edificio);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    @Override
    public Flux<Edificio> getEdificios() {
        return Flux.fromIterable(edificioDao.findAll());
    }

    @Override
    public Mono<Edificio> getEdificio(Long id) {
        return Mono.fromSupplier(() -> edificioDao.findById(id).orElse(null));
    }

    @Transactional
    @Override
    public Mono<Void> deleteEdificio(Long id) {
        return Mono.fromRunnable(() -> {
            EntityTransaction transaction = null;
            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                Edificio edificio = entityManager.find(Edificio.class, id);
                if (edificio != null) {
                    entityManager.remove(edificio);
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
