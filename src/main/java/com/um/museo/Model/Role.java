package com.um.museo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    private Long id;

    private String nombre;
}
