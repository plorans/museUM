package com.um.museo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    private Long id;
    private String personaje;
    private String fecha;
    private String historia;
    private String datos;
}
