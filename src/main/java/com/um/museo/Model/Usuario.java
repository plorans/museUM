package com.um.museo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
public class Usuario {
    @Id
    private Long id;
    private String user;
    private String email;
    private String password;
    private Boolean active;
}
