package com.example.sashabf.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository <Departamento,Long> {

	Departamento findByNombre(String nombreDepartamento);

}
