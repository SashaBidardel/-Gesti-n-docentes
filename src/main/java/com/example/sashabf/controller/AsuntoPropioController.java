package com.example.sashabf.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sashabf.entity.AsuntoPropio;
import com.example.sashabf.service.AsuntoPropioService;

@RestController
@RequestMapping("/api/asuntospropios")
public class AsuntoPropioController {
	
	private final AsuntoPropioService asuntoPropioService;

    public AsuntoPropioController(AsuntoPropioService asuntoPropioService) {
        this.asuntoPropioService = asuntoPropioService;
    }

    // Listar días propios aprobados de un docente
    @GetMapping("/aprobados/{docenteId}")
    public List<AsuntoPropio> listarAprobados(@PathVariable Long docenteId) {
        return asuntoPropioService.obtenerAprobados(docenteId);
    }

    // Listar días propios rechazados de un docente
    @GetMapping("/rechazados/{docenteId}")
    public List<AsuntoPropio> listarRechazados(@PathVariable Long docenteId) {
        return asuntoPropioService.obtenerRechazados(docenteId);
    }
    
    // solicitar un día propio
    @GetMapping("/solicitar")
    public ResponseEntity<Boolean> solicitarDiaPropio(
            @RequestParam Long docenteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {

       
		boolean valido = asuntoPropioService.solicitarAsuntoPropio(docenteId, fecha);
        return ResponseEntity.ok(valido);
    }
    // validar día propio
    @PostMapping("/validar")
    public ResponseEntity<AsuntoPropio> confirmarDiaPropio(
            @RequestParam Long docenteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {

        AsuntoPropio asuntoGuardado = asuntoPropioService.confirmarAsuntoPropio(docenteId, fecha);
        return ResponseEntity.ok(asuntoGuardado);
    }
}

    
