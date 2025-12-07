package com.example.sashabf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sashabf.repository.HorarioRepository;

@Service
public class HorarioService {
   @Autowired
   private HorarioRepository horarioRepository;
	

}
