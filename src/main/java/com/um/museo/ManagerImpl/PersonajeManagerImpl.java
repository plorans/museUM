package com.um.museo.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.PersonajeDao;
import com.um.museo.Manager.PersonajeManager;
import com.um.museo.Model.Documento;
import com.um.museo.Model.Personaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("PersonajeManager")
public class PersonajeManagerImpl implements PersonajeManager{

    @Autowired
    private PersonajeDao personajeDao;

    @Override
    public Mono<Personaje> savePersonaje(Personaje personaje) {
        return Mono.just(personajeDao.save(personaje));
    }

    @Override
    public Flux<Personaje> getPersonajes() {
        return Flux.fromIterable(personajeDao.findAll());
    }

    @Override
    public Mono<Personaje> getPersonaje(Long id) {
        return Mono.fromSupplier(() -> personajeDao.findById(id).orElse(null));
    }

    @Override
    public Mono<Personaje> removePersonaje(Long id) {
        return Mono.fromCallable(() -> {
            Personaje deletedPersonaje = personajeDao.findById(id).orElseThrow(() -> new NotFoundException());

            personajeDao.deleteById(id);

            return deletedPersonaje;
        });
    }
    
}
