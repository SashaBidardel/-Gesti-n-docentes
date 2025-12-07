package com.example.sashabf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sashabf.repository.GuardiaRepository;

@Service
public class GuardiaService {
	@Autowired
	private GuardiaRepository guardiaRepository;
	
}
