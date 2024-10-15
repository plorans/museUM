package com.um.museo.Model;

import java.util.Date;

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
@Table(name = "edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edificios_id_seq")
    @SequenceGenerator(name = "edificios_id_seq", sequenceName = "edificios_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "construccion", length = 150)
    private String construccion;

    @Column(name = "inauguracion", length = 150)
    private String inauguracion;

    @Column(name = "descripcion", length = 200)
    private String descripcion;
}
