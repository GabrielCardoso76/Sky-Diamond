package com.example.bloukemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bloukemon.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}