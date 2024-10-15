package com.um.museo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.museo.Manager.ImagenManager;
import com.um.museo.Model.Imagen;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/imagen")
public class ImagenController {
    
    @Autowired
    private ImagenManager imagenManager;

    @PostMapping()
    public Mono<Imagen> saveEdificio(Imagen Imagen) {
        return imagenManager.saveImagen(Imagen);
    }

    @DeleteMapping("/{id}")
    private Mono<Imagen> deleteEdificio(Long id) {
        return imagenManager.deleteImagen(id);
    }

    @GetMapping("/{id}")
    public Mono<Imagen> getImagen(@PathVariable Long id) {
        return imagenManager.getImagen(id);
    }

}
