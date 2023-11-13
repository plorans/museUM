package com.um.museo.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "edificios")
public class Edificio {
    @Id
    private Long id;
    private String nombre;
    private String construccion;
    private String inauguracion;
    private String descripcion;
}
