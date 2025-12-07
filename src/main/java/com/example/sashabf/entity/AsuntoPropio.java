package com.example.sashabf.entity;


	import java.time.LocalDateTime;
	import java.util.Date;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	@Table(name = "asuntos_propios")
	public class AsuntoPropio {
	  
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private Date diaSolicitado;
		private String descripcion;
		private LocalDateTime fechaTramitacion;
		private boolean aprobado;
		
		 @ManyToOne
		 @JoinColumn(name = "docente_id")
		 private Docente docente;

		
		

}
