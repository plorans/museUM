package com.um.museo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "imagen")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagen_id_seq")
    @SequenceGenerator(name = "imagen_id_seq", sequenceName = "imagen_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    private String path;
}
