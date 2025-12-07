package com.example.sashabf.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.sashabf.dto.DocenteDepartamentoDto;
import com.example.sashabf.dto.DocenteDto;
import com.example.sashabf.entity.Docente;

@Configuration
public class ModelMapperConfig {

	  @Bean
	    public ModelMapper modelMapper() {
	    
		ModelMapper mapper = new ModelMapper();
	     
		// Mapeo de Docente a DocenteDto
        mapper.createTypeMap(Docente.class, DocenteDto.class)
              .addMapping(src -> src.getId(), DocenteDto::setId)
              .addMapping(src -> src.getEmail(), DocenteDto::setEmail)
              .addMapping(src -> src.getNombre(),DocenteDto::setNombre)
         	  .addMapping(src -> src.getApellidos(),DocenteDto::setApellidos);
	    
        //Mapeo dos entidades Docente y Departamento
       TypeMap<Docente,DocenteDepartamentoDto> typeMap=
    		   mapper.createTypeMap(Docente.class, DocenteDepartamentoDto.class);
       typeMap.addMapping(src-> src.getDepartamento().getNombre(), DocenteDepartamentoDto::setNombreDepartamento );
        
        return mapper;

	    }

}
