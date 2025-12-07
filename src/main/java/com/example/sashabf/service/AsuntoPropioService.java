package com.example.sashabf.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sashabf.entity.AsuntoPropio;
import com.example.sashabf.entity.Docente;
import com.example.sashabf.repository.AsuntoPropioRepository;
import com.example.sashabf.repository.DocenteRepository;
@Service
public class AsuntoPropioService {

		@Autowired
		private AsuntoPropioRepository asuntoPropioRepository;
		

		   // Obtener días propios aprobados
	    public List<AsuntoPropio> obtenerAprobados(Long docenteId) {
	        return asuntoPropioRepository.findByDocenteIdAndAprobadoTrue(docenteId);
	    }

	    // Obtener días propios rechazados
	    public List<AsuntoPropio> obtenerRechazados(Long docenteId) {
	        return asuntoPropioRepository.findByDocenteIdAndAprobadoFalse(docenteId);
	    }
	    
	    // Solicitar día propio
	     public boolean solicitarAsuntoPropio(Long docenteId ,Date fecha) {
	    	// Comprobación de fecha válida
	         if (fecha == null || fecha.toLocalDate().isBefore(LocalDate.now())) {
	             return false; // fecha no válida
	         }
	         // Comprobar si ya hay día propio en los últimos 3 meses
	         LocalDate fechaSolicitada = fecha.toLocalDate();
	         LocalDate tresMesesAtras = fechaSolicitada.minusMonths(3);

	         List<AsuntoPropio> existentes = asuntoPropioRepository
	                 .findByDocenteIdAndDiaSolicitadoBetween(docenteId, Date.valueOf(tresMesesAtras), fecha);

	         if (!existentes.isEmpty()) {
	             return false; // Ya tiene un día propio en los últimos 3 meses
	         }
	    	     	
	         return true ;
	     }
	     
	  // Confirmar y guardar día propio
	     public AsuntoPropio confirmarAsuntoPropio(Long docenteId, Date fecha) {
	         AsuntoPropio asunto = new AsuntoPropio();
	         Docente docente = new Docente();
	         docente.setId(docenteId);

	         boolean valido = solicitarAsuntoPropio(docenteId, fecha);

	         asunto.setDiaSolicitado(fecha);
	         asunto.setDescripcion("Solicitud día propio de" + docente.getNombre() +" " + docente.getApellidos() +" en fecha: " + fecha);
	         asunto.setFechaTramitacion(null);
	         asunto.setAprobado(valido); // true si pasa validación, false si no
	         asunto.setDocente(docente);

	         return asuntoPropioRepository.save(asunto);
	     }
	     

}
