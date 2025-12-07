package com.example.sashabf.entity;
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
@Table(name = "horario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int dia;
	private int hora;
	private String aula;
	private String tipo;
	
	@OneToOne
	@JoinColumn(name="guardia_id")
	private Guardia guardia;
	
	@ManyToOne
	@JoinColumn(name="docente_id")
	private Docente docente;

}
