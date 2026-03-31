package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CorteTurno;
import com.example.demo.service.CorteTurnoService;

@RestController
@RequestMapping("/corte") // La URL será http://localhost:8081/corte
@CrossOrigin(origins = "*")
public class CorteTurnoController {

    @Autowired
    CorteTurnoService corteTurnoService;

    // Guardar el corte y calcular el dinero
    @PostMapping()
    public CorteTurno guardarCorte(@RequestBody CorteTurno corte) {
        return corteTurnoService.guardarCorte(corte);
    }
}