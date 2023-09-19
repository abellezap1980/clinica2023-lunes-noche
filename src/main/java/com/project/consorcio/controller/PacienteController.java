package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Categoria;
import com.project.consorcio.entity.Paciente;
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
	//ruta o direccion URL para invocar al método grabar
		@RequestMapping("/grabar")
		public String grabar(@RequestParam("codigo") Integer codi,
							 @RequestParam("nombre") String nom,
							 @RequestParam("apellido") String ape,
							 @RequestParam("sexo") String sexo,
							 @RequestParam("categoria") int codCate,
							 RedirectAttributes redirect) {		
			try {
				Paciente bean=new Paciente();
				//setear atributos del objeto "med" usando los parámetros
				bean.setNombre(nom);
				bean.setApellido(ape);
				bean.setSexo(sexo);
				Categoria cate=new Categoria();
				cate.setCodigo(codCate);
				bean.setCategoria(cate);
				if(codi==0) {
					servicioPaci.registrar(bean);
					redirect.addFlashAttribute("MENSAJE","Paciente registrado");
				}
				else {
					bean.setCodigo(codi);
					servicioPaci.actualizar(bean);
					redirect.addFlashAttribute("MENSAJE","Paciente actualizado");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/paciente/lista";
		}
	
}





