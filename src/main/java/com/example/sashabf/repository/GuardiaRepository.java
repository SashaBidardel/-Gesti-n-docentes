package com.example.sashabf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sashabf.entity.Guardia;

@Repository
public interface GuardiaRepository extends JpaRepository <Guardia,Long> {

	

}
