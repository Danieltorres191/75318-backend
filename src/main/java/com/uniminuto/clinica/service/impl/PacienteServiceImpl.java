package com.uniminuto.clinica.service.impl;

import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.repository.PacienteRepository;
import com.uniminuto.clinica.service.PacienteService;
import java.util.List;
import java.util.Optional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago Cuevas
 */
@Service
public class PacienteServiceImpl implements PacienteService{
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Override
    public List<Paciente> listarTodosLosPacientes() {
        return this.pacienteRepository.findAll();
    }
    @Override
    public Paciente encontrarPorDocumento(String documento) 
                throws BadRequestException {
        Optional<Paciente> optUser = this.pacienteRepository
                .findByDocumento(documento);
        if (!optUser.isPresent()) {
            throw new BadRequestException("No existe el Paciente");
    }
        return optUser.get();
    }
}

