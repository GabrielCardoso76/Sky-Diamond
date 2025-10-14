package com.example.bloukemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bloukemon.model.Blouke;

public interface BloukeRepository extends JpaRepository<Blouke, Long> {
}