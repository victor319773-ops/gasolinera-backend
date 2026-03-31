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
@Table(name = "cortes_turno")
public class CorteTurno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quién está cerrando el turno
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario despachador;

    // Qué bomba está cerrando
    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    private Bomba bomba;

    // --- LECTURAS DE CARRETES (MAGNA) ---
    @Column(nullable = false)
    private Double lecturaInicialMagna;
    
    @Column(nullable = false)
    private Double lecturaFinalMagna;

    // --- LECTURAS DE CARRETES (PREMIUM) ---
    @Column(nullable = false)
    private Double lecturaInicialPremium;
    
    @Column(nullable = false)
    private Double lecturaFinalPremium;

    // --- TICKETS Y OTROS PAGOS ---
    @Column(nullable = false)
    private Double totalTarjetas; // Lo pagado con terminal bancaria
    
    @Column(nullable = false)
    private Integer cantidadFolios; // Cuántos vales/folios de 1000 entregó
    
    @Column(nullable = false)
    private Double precioMagnaActual;

    @Column(nullable = false)
    private Double precioPremiumActual;

    public Double getPrecioMagnaActual() {
		return precioMagnaActual;
	}

	public void setPrecioMagnaActual(Double precioMagnaActual) {
		this.precioMagnaActual = precioMagnaActual;
	}

	public Double getPrecioPremiumActual() {
		return precioPremiumActual;
	}

	public void setPrecioPremiumActual(Double precioPremiumActual) {
		this.precioPremiumActual = precioPremiumActual;
	}
	// --- RESULTADOS CALCULADOS POR EL BACKEND ---
    private Double totalEfectivoEntregar; // El resultado final de la fórmula
    private LocalDateTime fechaHoraCorte;

    // --- CONSTRUCTORES ---
    public CorteTurno() {
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getDespachador() { return despachador; }
    public void setDespachador(Usuario despachador) { this.despachador = despachador; }

    public Bomba getBomba() { return bomba; }
    public void setBomba(Bomba bomba) { this.bomba = bomba; }

    public Double getLecturaInicialMagna() { return lecturaInicialMagna; }
    public void setLecturaInicialMagna(Double lecturaInicialMagna) { this.lecturaInicialMagna = lecturaInicialMagna; }

    public Double getLecturaFinalMagna() { return lecturaFinalMagna; }
    public void setLecturaFinalMagna(Double lecturaFinalMagna) { this.lecturaFinalMagna = lecturaFinalMagna; }

    public Double getLecturaInicialPremium() { return lecturaInicialPremium; }
    public void setLecturaInicialPremium(Double lecturaInicialPremium) { this.lecturaInicialPremium = lecturaInicialPremium; }

    public Double getLecturaFinalPremium() { return lecturaFinalPremium; }
    public void setLecturaFinalPremium(Double lecturaFinalPremium) { this.lecturaFinalPremium = lecturaFinalPremium; }

    public Double getTotalTarjetas() { return totalTarjetas; }
    public void setTotalTarjetas(Double totalTarjetas) { this.totalTarjetas = totalTarjetas; }

    public Integer getCantidadFolios() { return cantidadFolios; }
    public void setCantidadFolios(Integer cantidadFolios) { this.cantidadFolios = cantidadFolios; }

    public Double getTotalEfectivoEntregar() { return totalEfectivoEntregar; }
    public void setTotalEfectivoEntregar(Double totalEfectivoEntregar) { this.totalEfectivoEntregar = totalEfectivoEntregar; }

    public LocalDateTime getFechaHoraCorte() { return fechaHoraCorte; }
    public void setFechaHoraCorte(LocalDateTime fechaHoraCorte) { this.fechaHoraCorte = fechaHoraCorte; }

	
}