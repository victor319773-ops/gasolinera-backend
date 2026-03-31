package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Venta;
import com.example.demo.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    // 1. Obtener todas las ventas
    public ArrayList<Venta> obtenerVentas() {
        return (ArrayList<Venta>) ventaRepository.findAll();
    }

    // 2. Guardar una nueva venta con lógica backend
    public Venta guardarVenta(Venta venta) {
        // LÓGICA BACKEND: El servidor le pone la fecha y hora exacta del momento de la venta
        venta.setFechaHora(LocalDateTime.now());
        
        return ventaRepository.save(venta);
    }
}