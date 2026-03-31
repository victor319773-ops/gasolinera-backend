package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bombas") // Así se llamará la tabla en tu XAMPP
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // El número único de la bomba en el sistema

    @Column(nullable = false, unique = true)
    private String numeroBomba; // Ej: "Bomba 1", "Bomba 2"

    @Column(nullable = false)
    private String tipoCombustible; // Ej: "Magna", "Premium", "Diesel"
    
    @Column(nullable = false)
    private Boolean activa; // Para saber si la bomba está funcionando o en mantenimiento

    // --- CONSTRUCTORES ---
    public Bomba() {
    }

    public Bomba(String numeroBomba, String tipoCombustible, Boolean activa) {
        this.numeroBomba = numeroBomba;
        this.tipoCombustible = tipoCombustible;
        this.activa = activa;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBomba() {
        return numeroBomba;
    }

    public void setNumeroBomba(String numeroBomba) {
        this.numeroBomba = numeroBomba;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}