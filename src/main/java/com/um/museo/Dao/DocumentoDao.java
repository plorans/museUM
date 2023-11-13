package com.um.museo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.museo.Model.Documento;

@Repository
public interface DocumentoDao extends JpaRepository<Documento,Long> {
    
}
