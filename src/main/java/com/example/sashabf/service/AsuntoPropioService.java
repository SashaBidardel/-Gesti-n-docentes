package com.example.sashabf.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.sashabf.entity.AsuntoPropio;
import com.example.sashabf.entity.Docente;
import com.example.sashabf.repository.AsuntoPropioRepository;
import com.example.sashabf.repository.DocenteRepository;


@Service
public class AsuntoPropioService {

    @Autowired
    private AsuntoPropioRepository asuntoPropioRepository;

    @Autowired
    private DocenteRepository docenteRepository;
    
 // Consultar días propios aprobados
    public List<AsuntoPropio> obtenerAprobados(Long docenteId) {
        return asuntoPropioRepository.findByDocenteIdAndAprobadoTrue(docenteId);
    }

    // Consultar días propios rechazados
    public List<AsuntoPropio> obtenerRechazados(Long docenteId) {
        return asuntoPropioRepository.findByDocenteIdAndAprobadoFalse(docenteId);
    }
    // Método que solo comprueba si un día puede solicitarse → devuelve true o false
    public boolean solicitarAsuntoPropio(Long docenteId, LocalDate fecha) {
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            return false; // Fecha nula o pasada
        }

        // Consultamos si ya existe un día solicitado para esa fecha
        boolean existe = !asuntoPropioRepository
                .findByDocenteIdAndDiaSolicitado(docenteId, Date.valueOf(fecha))
                .isEmpty();

        if (existe) {
            return false; // Ya existe solicitud para ese día
        }

        // Consultamos si hay solicitudes en los últimos 3 meses
        LocalDate tresMesesAtras = fecha.minusMonths(3);
        boolean recientes = !asuntoPropioRepository
                .findByDocenteIdAndDiaSolicitadoBetween(
                        docenteId,
                        Date.valueOf(tresMesesAtras),
                        Date.valueOf(fecha))
                .isEmpty();

        return !recientes;
    }

   

    // validar dia asunto propio
    public AsuntoPropio confirmarAsuntoPropio(Long docenteId, LocalDate fecha) {

        // Obtener el docente
        Docente docente = docenteRepository.findById(docenteId)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        boolean valido=solicitarAsuntoPropio(docenteId,fecha);
        // Crear el AsuntoPropio
        AsuntoPropio asunto = new AsuntoPropio();
        asunto.setDiaSolicitado(Date.valueOf(fecha));
        asunto.setFechaTramitacion(LocalDateTime.now());
        if (valido) {//ponemos el aprobado a true y la descripción correspondiente
        	asunto.setAprobado(true);
        	// Añadir descripción
            asunto.setDescripcion(
                    "Solicitud de día propio de " +
                    docente.getNombre() + " " +
                    docente.getApellidos() +
                    " para la fecha " + fecha +
                    "aprobado"
            );
        }else {//ponemos el aprobado a false y la descripción correspondiente
        	asunto.setAprobado(false);
        	// Añadir descripción
            asunto.setDescripcion(
                    "Solicitud de día propio de " +
                    docente.getNombre() + " " +
                    docente.getApellidos() +
                    " para la fecha " + fecha +
                    "rechazado"
            );
        }
        asunto.setDocente(docente);

        

        // Guardar en BD
        return asuntoPropioRepository.save(asunto);
    }

}

