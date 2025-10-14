package com.example.bloukemon.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Blouke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int nivel;
    private int experienciaAtual;
    private int experienciaParaProximoNivel;

    // Atributos base
    private int hpMaximo;
    private int ataque;
    private int defesa;
    private int velocidade;

    // Atributos em batalha (que mudam constantemente)
    private int hpAtual;

    @ManyToOne
    private Tipo tipoPrimario;

    @ManyToOne
    private Tipo tipoSecundario; // Pode ser nulo

    @ManyToMany
    private List<Movimento> movimentos; // Os 4 ataques que o Blouke conhece

    @ManyToOne
    private Jogador treinador; // Para saber a quem pertence (se não for selvagem)
}