package com.example.demo2.repository;

import com.example.demo2.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudioRepository extends JpaRepository<Estudios, Long> {
}
