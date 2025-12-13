package com.example.sashabf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sashabf.entity.Docente;
import com.example.sashabf.service.DepartamentoService;
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

	private DepartamentoService departamentoService;
    
	public DepartamentoController(DepartamentoService departamentoService) {
		super();
		this.departamentoService = departamentoService;
	}
	@GetMapping("docentes/{nombre}")
	public List<Docente> docentesNombreDepartamento (@PathVariable String nombre){
		return departamentoService.listarDocentesNombre(nombre);
	}
	@GetMapping("/numero_docentes/{nombre}")
	public long numeroProfesoresPorDepartamento (@PathVariable String nombre){
		return departamentoService.numeroProfersoresPorDepartamento(nombre);
	}
	
}
