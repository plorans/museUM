package com.um.museo.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edificios_id_seq")
    @SequenceGenerator(name = "edificios_id_seq", sequenceName = "edificios_id_seq",  allocationSize = 1)
    private Long id;
    private String nombre;
    private String construccion;
    private String inauguracion;
    private String descripcion;
}
