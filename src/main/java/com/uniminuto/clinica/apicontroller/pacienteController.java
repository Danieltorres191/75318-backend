package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Servicio 1: Listar todos los pacientes
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    // Servicio 2: Buscar paciente por documento
    @GetMapping("/{documento}")
    public Paciente buscarPorDocumento(@PathVariable String documento) {
        return pacienteService.buscarPorDocumento(documento);
    }
}

