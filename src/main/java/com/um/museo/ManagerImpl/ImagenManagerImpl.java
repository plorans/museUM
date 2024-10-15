package com.um.museo.ManagerImpl;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.museo.Dao.ImagenDao;
import com.um.museo.Manager.ImagenManager;
import com.um.museo.Model.Imagen;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service("ImagenManager")
@Slf4j
public class ImagenManagerImpl implements ImagenManager {

    @Autowired 
    private ImagenDao imagenDao;

    @Override
    public Mono<Imagen> saveImagen(Imagen imagen) {
        return Mono.just(imagenDao.save(imagen));
    }

    @Override
    public Mono<Imagen> getImagen(Long id) {
        Imagen salida = imagenDao.findById(id).orElseThrow();
        log.info("imagen: " + salida);
        return Mono.fromSupplier(() -> salida);
    }

    @Override
    public Mono<Imagen> deleteImagen(Long id) {
        return Mono.fromCallable(() -> {
            Imagen deletedImagen = imagenDao.findById(id).orElseThrow(() -> new NameNotFoundException());

            imagenDao.deleteById(id);

            return deletedImagen;
        });
    }
    
}
