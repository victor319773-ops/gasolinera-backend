package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bomba;
import com.example.demo.model.BombaService;

@RestController
@RequestMapping("/bomba")
@CrossOrigin(origins = "*")
public class BombaController {

    @Autowired
    BombaService bombaService;

    @GetMapping()
    public ArrayList<Bomba> obtenerBombas() {
        return bombaService.obtenerBombas();
    }

    @PostMapping()
    public Bomba guardarBomba(@RequestBody Bomba bomba) {
        return bombaService.guardarBomba(bomba);
    }

    @GetMapping(path = "/{id}")
    public Optional<Bomba> obtenerBombaPorId(@PathVariable("id") Long id) {
        return bombaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = bombaService.eliminarBomba(id);
        if (ok) {
            return "Se eliminó la bomba con id " + id;
        } else {
            return "No pudo eliminar la bomba con id " + id;
        }
    }
}