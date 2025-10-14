package com.example.bloukemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bloukemon.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}