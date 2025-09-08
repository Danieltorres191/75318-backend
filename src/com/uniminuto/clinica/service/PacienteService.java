package com.uniminuto.clinica.service;

import com.uniminuto.clinica.entity.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteService {

    private final List<Paciente> pacientes = new ArrayList<>();

    public PacienteService() {
        // "Tabla" de pacientes simulada
        pacientes.add(new Paciente("123", "Juan Perez"));
        pacientes.add(new Paciente("456", "Ana Gomez"));
        pacientes.add(new Paciente("789", "Carlos Ruiz"));
    }

    // Listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    // Buscar paciente por documento y devolver solo el nombre
    public String buscarNombrePorDocumento(String documento) {
        for (Paciente p : pacientes) {
            if (p.getDocumento().equals(documento)) {
                return p.getNombre();
            }
        }
        return "Paciente no encontrado";
    }
}
