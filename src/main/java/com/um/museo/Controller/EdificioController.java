package com.um.museo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.museo.Manager.EdificioManager;
import com.um.museo.Model.Edificio;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/edificio")
@Slf4j
public class EdificioController {

    @Autowired
    private EdificioManager edificioManager;

    

    @PostMapping()
    public Mono<Edificio> saveEdificio(@RequestBody Edificio edificio) {
        return edificioManager.saveEdificio(edificio);
    }

    @DeleteMapping("/{id}")
    private Mono<Edificio> deleteEdificio(@PathVariable Long id){
        return edificioManager.deleteEdificio(id);
    }

    @GetMapping("/{id}")
    public Mono<Edificio> getEdificio(@PathVariable Long id){
        return edificioManager.getEdificio(id);
    }

    @GetMapping()
    public Flux<Edificio> getEdificios(){

        log.info("entro");
        return edificioManager.getEdificios();
    }
}
