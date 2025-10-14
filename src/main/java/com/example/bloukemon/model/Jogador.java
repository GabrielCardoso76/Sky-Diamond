package com.example.bloukemon.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Jogador extends Usuario {
    private int dinheiro;
    private int pos_x; // Posição atual no mapa (eixo X)
    private int pos_y; // Posição atual no mapa (eixo Y)

    @OneToMany(mappedBy = "treinador")
    private List<Blouke> time; // A equipe de Bloukes do jogador (máx 6)
}