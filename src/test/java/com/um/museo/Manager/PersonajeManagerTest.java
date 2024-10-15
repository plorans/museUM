package com.um.museo.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.um.museo.Dao.PersonajeDao;
import com.um.museo.ManagerImpl.PersonajeManagerImpl;
import com.um.museo.Model.Personaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class PersonajeManagerTest {

    @Autowired
    private PersonajeManagerImpl personajeManager;

    @MockBean
    private PersonajeDao personajeDao;

    @Test
    void testSavePersonaje() {
        Personaje personaje = new Personaje();
        when(personajeDao.save(any(Personaje.class))).thenReturn(personaje);

        Mono<Personaje> result = personajeManager.savePersonaje(personaje);

        assertNotNull(result);
        assertEquals(personaje, result.block());
        verify(personajeDao).save(personaje);
    }

    @Test
    void testGetPersonaje() {
        Personaje personaje = new Personaje();
        when(personajeDao.findById(1L)).thenReturn(Optional.of(personaje));

        Mono<Personaje> result = personajeManager.getPersonaje(1L);

        assertNotNull(result);
        assertEquals(personaje, result.block());
        verify(personajeDao).findById(1L);
    }

    @Test
    void testGetPersonajes() {
        Personaje personaje1 = new Personaje();
        Personaje personaje2 = new Personaje();
        when(personajeDao.findAll()).thenReturn(Arrays.asList(personaje1, personaje2));

        Flux<Personaje> result = personajeManager.getPersonajes();

        assertNotNull(result);
        assertEquals(2, result.count().block());
        verify(personajeDao).findAll();
    }

    @Test
    void testRemovePersonaje() {
        Personaje personaje = new Personaje();
        when(personajeDao.findById(1L)).thenReturn(Optional.of(personaje));

        Mono<Personaje> result = personajeManager.removePersonaje(1L);

        assertNotNull(result);
        assertEquals(personaje, result.block());
        verify(personajeDao).deleteById(1L);
    }

    
}
