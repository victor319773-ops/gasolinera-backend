package com.example.demo.model;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bomba;
import com.example.demo.repository.BombaRepository;

@Service
public class BombaService {

    @Autowired
    BombaRepository bombaRepository; // Inyectamos el repositorio para usarlo

    // 1. Obtener todas las bombas
    public ArrayList<Bomba> obtenerBombas() {
        return (ArrayList<Bomba>) bombaRepository.findAll();
    }

    // 2. Guardar una nueva bomba
    public Bomba guardarBomba(Bomba bomba) {
        // Aquí podrías meter lógica backend en el futuro.
        // Ej: Validar que no se repita el número de bomba.
        return bombaRepository.save(bomba);
    }

    // 3. Buscar una bomba por su ID
    public Optional<Bomba> obtenerPorId(Long id) {
        return bombaRepository.findById(id);
    }

    // 4. Eliminar una bomba por ID
    public boolean eliminarBomba(Long id) {
        try {
            bombaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}