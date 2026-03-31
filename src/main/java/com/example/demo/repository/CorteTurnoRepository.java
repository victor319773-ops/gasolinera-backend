package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.CorteTurno;

@Repository
public interface CorteTurnoRepository extends JpaRepository<CorteTurno, Long> {
}