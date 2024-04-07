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
@Table(name = "personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personaje_id_seq")
    @SequenceGenerator(name = "personaje_id_seq", sequenceName = "personaje_id_seq",  allocationSize = 1)
    private Long id;
    private String nombre;
    private String fecha;
    private String historia;
    private String datos;
}
