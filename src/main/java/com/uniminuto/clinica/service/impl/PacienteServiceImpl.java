package com.uniminuto.clinica.service.impl;

import java.util.List;
import java.util.Optional;
import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.repository.PacienteRepository;
import com.uniminuto.clinica.service.PacienteService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarPacientes() { return this.pacienteRepository.findAll();}

    @Override
    public Paciente buscarPorDocumento(String numeroDocumento)
            throws BadRequestException {

        Optional<Paciente> optPaciente =
                this.pacienteRepository.findByNumeroDocumento(numeroDocumento);

        if (!optPaciente.isPresent()) {
            throw new BadRequestException("No se encuentra el paciente");
        }

        return optPaciente.get();
    }
}
