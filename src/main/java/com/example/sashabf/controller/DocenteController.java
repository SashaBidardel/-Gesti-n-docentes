package com.example.sashabf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sashabf.dto.DocenteDepartamentoDto;
import com.example.sashabf.dto.DocenteDto;
import com.example.sashabf.entity.Docente;
import com.example.sashabf.service.DocenteService;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

	private DocenteService docenteService;

	public DocenteController(DocenteService docenteService) {
		this.docenteService = docenteService;
	}
	
	// Listar todos los docentes por orden de apellidos
    @GetMapping
    public List<Docente> listarDocentes() {
        return docenteService.listarDocentesApellidos();
    }

   // listar todos los docentes en formato DTO
    @GetMapping("/dto/docentes")
    public List<DocenteDto> listarDocentesDTO() {
        return docenteService.listarDocentesDTO();
    }
  
    // listar docentes DTO por nombre de departamento
    @GetMapping("/dto/departamento/{nombreDep}")
    public List<DocenteDepartamentoDto> listarDocentesPorDepartamento( @PathVariable String nombreDep) {
        return docenteService.listarDocentesPorDepartamento(nombreDep);
    }

    
}
