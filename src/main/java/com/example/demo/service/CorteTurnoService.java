package com.example.demo.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.CorteTurno;
import com.example.demo.repository.CorteTurnoRepository;

@Service
public class CorteTurnoService {

    @Autowired
    CorteTurnoRepository corteTurnoRepository;

    public CorteTurno guardarCorte(CorteTurno corte) {
        
        // 1. Calcular litros vendidos
        Double litrosMagna = corte.getLecturaFinalMagna() - corte.getLecturaInicialMagna();
        Double litrosPremium = corte.getLecturaFinalPremium() - corte.getLecturaInicialPremium();
        
        // 2. Multiplicar por el costo que MANDAMOS DESDE EL FRONT
        Double dineroMagna = litrosMagna * corte.getPrecioMagnaActual();
        Double dineroPremium = litrosPremium * corte.getPrecioPremiumActual();
        Double totalVentaTeorica = dineroMagna + dineroPremium;
        
        // 3. Calcular el valor de los folios
        Double dineroFolios = corte.getCantidadFolios() * 1000.0;
        
        // 4. Fórmula del negocio
        Double efectivoAEntregar = totalVentaTeorica - corte.getTotalTarjetas() - dineroFolios;
        
        // 5. Guardar cálculos automáticos
        corte.setTotalEfectivoEntregar(efectivoAEntregar);
        corte.setFechaHoraCorte(LocalDateTime.now());
        
        return corteTurnoRepository.save(corte);
    }
}