package com.example.demo2.repository;

import com.example.demo2.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
