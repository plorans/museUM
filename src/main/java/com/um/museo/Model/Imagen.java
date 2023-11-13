package com.um.museo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "imagen")
public class Imagen {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
}
