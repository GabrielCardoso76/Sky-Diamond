package com.example.bloukemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int poder; // O dano base do ataque
    private int precisao; // A chance de acertar (ex: 95%)
    private int ppMaximo; // Quantas vezes pode ser usado

    @ManyToOne
    private Tipo tipo; // O tipo elemental do movimento
}