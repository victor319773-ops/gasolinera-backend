package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACIÓN: Muchas ventas pertenecen a UN despachador (Usuario)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario despachador;

    // RELACIÓN: Muchas ventas pertenecen a UNA bomba
    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    private Bomba bomba;

    @Column(nullable = false)
    private Double litros;

    @Column(nullable = false)
    private Double totalDinero;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    // --- CONSTRUCTORES ---
    public Venta() {
    }

    public Venta(Usuario despachador, Bomba bomba, Double litros, Double totalDinero, LocalDateTime fechaHora) {
        this.despachador = despachador;
        this.bomba = bomba;
        this.litros = litros;
        this.totalDinero = totalDinero;
        this.fechaHora = fechaHora;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getDespachador() {
        return despachador;
    }

    public void setDespachador(Usuario despachador) {
        this.despachador = despachador;
    }

    public Bomba getBomba() {
        return bomba;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public Double getTotalDinero() {
        return totalDinero;
    }

    public void setTotalDinero(Double totalDinero) {
        this.totalDinero = totalDinero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}