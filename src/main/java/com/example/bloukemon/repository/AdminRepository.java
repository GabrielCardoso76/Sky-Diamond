package com.example.bloukemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bloukemon.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}