package com.um.museo.Model;

import java.sql.Date;

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
@Table(name = "documentos")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentos_id_seq")
    @SequenceGenerator(name = "documentos_id_seq", sequenceName = "documentos_id_seq",  allocationSize = 1)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "descripcion", length =  250)
    private String descripcion;
}
