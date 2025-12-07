package com.example.sashabf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository <Docente,Long> {

	List<Docente> findAllByOrderByApellidosAsc();
   
}
