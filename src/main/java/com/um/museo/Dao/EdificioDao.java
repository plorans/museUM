package com.um.museo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.museo.Model.Edificio;

@Repository
public interface EdificioDao extends JpaRepository<Edificio,Long> {
    
}
