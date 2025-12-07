package com.example.sashabf.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "guardia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Guardia {
     
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date fecha;
	private String anotacion;
	private String material;
	
	@ManyToOne
	@JoinColumn(name="docente_id")
	private Docente docente;
	
	@OneToOne
	@JoinColumn(name="horario_id")
	private Horario horario;
	
}
