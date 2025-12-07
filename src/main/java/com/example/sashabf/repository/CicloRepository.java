package com.example.sashabf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.Ciclo;

@Repository
public interface CicloRepository extends JpaRepository <Ciclo,Long> {

	

}
