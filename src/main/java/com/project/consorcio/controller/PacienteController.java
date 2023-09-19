package com.project.consorcio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.consorcio.service.CategoriaServices;
import com.project.consorcio.service.PacienteServices;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private CategoriaServices servicioCate;
	@Autowired
	private PacienteServices servicioPaci;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("pacientes",servicioPaci.listarTodos());
		model.addAttribute("categorias",servicioCate.listarTodos());
		return "paciente";
	}
	
	
}





