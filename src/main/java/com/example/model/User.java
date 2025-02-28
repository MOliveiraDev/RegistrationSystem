package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "usuario") //Define o nome da tabela
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private long id;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

}
