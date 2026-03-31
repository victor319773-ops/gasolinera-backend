package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<Usuario> obtenerUsuarios(){
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}
	
	
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> obtenerPorId(long id) {
		return usuarioRepository.findById(id);
	}
	
	
	public ArrayList<Usuario> obtenerPorPrioridad(Integer prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}
	
	public boolean eliminarUsuarios(long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
