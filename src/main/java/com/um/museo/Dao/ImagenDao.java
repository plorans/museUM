package com.um.museo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.museo.Model.Imagen;

@Repository
public interface ImagenDao extends JpaRepository<Imagen,Long>{

}
