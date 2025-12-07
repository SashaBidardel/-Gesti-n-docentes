package com.example.sashabf.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.AsuntoPropio;

@Repository
public interface AsuntoPropioRepository extends JpaRepository <AsuntoPropio,Long> {

	// Listar aprobados para un docente
	List<AsuntoPropio> findByDocenteIdAndAprobadoTrue(Long docenteId);

	// Listar rechazados para un docente
	List<AsuntoPropio> findByDocenteIdAndAprobadoFalse(Long docenteId);

	List<AsuntoPropio> findByDocenteIdAndDiaSolicitadoBetween(Long docenteId, Date valueOf, Date fecha);

}
