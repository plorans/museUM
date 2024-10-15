package com.um.museo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.um.museo.Model.Usuario;
import java.util.List;


public interface UsuarioDao extends JpaRepository<Usuario,Long>{

    Usuario findByEmail(String email);
    
}
