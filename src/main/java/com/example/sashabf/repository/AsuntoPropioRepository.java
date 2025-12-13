package com.example.sashabf.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.AsuntoPropio;

@Repository
public interface AsuntoPropioRepository extends JpaRepository<AsuntoPropio, Long> {

    // Obtener días propios aprobados de un docente
    List<AsuntoPropio> findByDocenteIdAndAprobadoTrue(Long docenteId);

    // Obtener días propios rechazados de un docente
    List<AsuntoPropio> findByDocenteIdAndAprobadoFalse(Long docenteId);

    // Comprobar si el docente ya tiene un día propio en un rango de fechas
    List<AsuntoPropio> findByDocenteIdAndDiaSolicitadoBetween(Long docenteId,Date fechaInicio,Date fechaFin);

	List<AsuntoPropio> findByDocenteIdAndDiaSolicitado(Long docenteId, Date valueOf);
            
 }

