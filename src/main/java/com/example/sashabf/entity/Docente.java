package com.example.sashabf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "docente")
public class Docente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String siglas;
	private String tipo;
	private Date antiguedad;
	private int posicion;
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;
	
    @OneToMany(mappedBy="docente")
    private List<Guardia> guardias;
	
	@OneToMany(mappedBy="docente")
	@JsonIgnore //para cuando nos piden la lista de docentes por nombre de departamento
    private List<AsuntoPropio> asuntosPropios;
	
	@OneToMany(mappedBy="docente")
	private List<Horario> horarios;
    
    
}
