package com.example.sashabf.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // Listar días propios aprobados
    @GetMapping("/aprobados/{docenteId}")
    public List<AsuntoPropio> listarAprobados(@PathVariable Long docenteId) {
        return asuntoPropioService.obtenerAprobados(docenteId);
    }

    // Listar días propios rechazados
    @GetMapping("/rechazados/{docenteId}")
    public List<AsuntoPropio> listarRechazados(@PathVariable Long docenteId) {
        return asuntoPropioService.obtenerRechazados(docenteId);
    }

    // Solicitar un día propio (solo validación)
    @GetMapping("/solicitar/{docenteId}")
    public ResponseEntity<Boolean> solicitarDiaPropio(
            @PathVariable Long docenteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        boolean valido = asuntoPropioService.solicitarAsuntoPropio(docenteId, fecha);
        return ResponseEntity.ok(valido);
    }

    // Validar (confirmar) un día de asuntos propios
    @PostMapping("/validar/{docenteId}")
    public ResponseEntity<AsuntoPropio> confirmarDiaPropio(
            @PathVariable Long docenteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        AsuntoPropio asuntoGuardado = asuntoPropioService.confirmarAsuntoPropio(docenteId, fecha);
        return ResponseEntity.ok(asuntoGuardado);
    }
}
