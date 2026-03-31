package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;

@RestController
@RequestMapping("/venta") // La URL de este controlador será http://localhost:8081/venta
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    VentaService ventaService;

    // 1. Obtener todas las ventas (GET)
    @GetMapping()
    public ArrayList<Venta> obtenerVentas() {
        return ventaService.obtenerVentas();
    }

    // 2. Guardar una nueva venta (POST)
    @PostMapping()
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }
}