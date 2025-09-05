package com.uniminuto.clinica.service;

import java.util.List;
import com.uniminuto.clinica.entity.Paciente;
import org.apache.coyote.BadRequestException;

public interface PacienteService {
    List<Paciente> listarPacientes();

    Paciente buscarPorDocumento(String numeroDocumento)
            throws BadRequestException;
}
