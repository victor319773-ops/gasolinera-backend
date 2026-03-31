package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Bomba;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Long> {
    // Al heredar de JpaRepository, Spring Boot ya nos regala
    // los métodos para Guardar, Buscar, Eliminar y Actualizar bombas.
}