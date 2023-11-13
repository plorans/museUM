package com.um.museo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.museo.Model.Personaje;

@Repository
public interface PersonajeDao extends JpaRepository<Personaje,Long>{
    
}
