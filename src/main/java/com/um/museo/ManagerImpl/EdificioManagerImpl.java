package com.um.museo.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.EdificioDao;
import com.um.museo.Manager.EdificioManager;
import com.um.museo.Model.Edificio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("EdificioManager")
public class EdificioManagerImpl implements EdificioManager {

    @Autowired
    private EdificioDao edificioDao;

    @Override
    @Transactional
    public Mono<Edificio> saveEdificio(Edificio edificio) {
        return Mono.just(edificioDao.save(edificio));
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
    public Mono<Edificio> deleteEdificio(Long id) {
        return Mono.fromCallable(() -> {
            Edificio deletedEdificio = edificioDao.findById(id).orElseThrow(() -> new NotFoundException());

            edificioDao.deleteById(id);

            return deletedEdificio;
        });
    }

}
