package com.example.sashabf.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sashabf.entity.Docente;
import com.example.sashabf.repository.DepartamentoRepository;



@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
    
	public List<Docente> listarDocentesNombre(String departamento){
		return departamentoRepository.findByNombre(departamento).getDocentes();
	}
}
