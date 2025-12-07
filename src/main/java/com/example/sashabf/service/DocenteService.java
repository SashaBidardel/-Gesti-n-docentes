package com.example.sashabf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sashabf.dto.DocenteDepartamentoDto;
import com.example.sashabf.dto.DocenteDto;
import com.example.sashabf.entity.Docente;
import com.example.sashabf.repository.DepartamentoRepository;
import com.example.sashabf.repository.DocenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocenteService {
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private ModelMapper modelMapper;

	 public List<Docente> listarDocentesApellidos() {
	        return docenteRepository.findAllByOrderByApellidosAsc();
	    }
	 public List<DocenteDto> listarDocentesDTO() {
		    return docenteRepository.findAll()
		            .stream()
		            .map(docente -> modelMapper.map(docente, DocenteDto.class))
		            .toList();
		}
     
	 public List<DocenteDepartamentoDto> listarDocentesPorDepartamento(String nombreDepartamento) {
	        return docenteRepository.findAll()
	                .stream()
	                .filter(docente -> docente.getDepartamento() != null &&
                    docente.getDepartamento().getNombre().equalsIgnoreCase(nombreDepartamento))
	                .map(docente -> {
	                DocenteDepartamentoDto dto = modelMapper.map(docente, DocenteDepartamentoDto.class);
	                return dto;
	                })
	                .toList();
	    }
}
