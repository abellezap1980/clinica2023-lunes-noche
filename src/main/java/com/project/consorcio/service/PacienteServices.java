package com.project.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.PacienteRepository;
import com.project.consorcio.entity.Paciente;

@Service
public class PacienteServices {
	@Autowired
	private PacienteRepository repo;
	
	public void registrar(Paciente bean) {
		repo.save(bean);
	}
	public void actualizar(Paciente bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Paciente buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Paciente> listarTodos(){
		return repo.findAll();
	}
	
}





