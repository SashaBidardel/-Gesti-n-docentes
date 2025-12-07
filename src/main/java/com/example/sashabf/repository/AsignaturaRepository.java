package com.example.sashabf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository <Asignatura,Long> {

	

}
