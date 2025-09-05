package com.uniminuto.clinica.service;

import com.uniminuto.clinica.entity.Paciente;
import java.util.List;
import org.apache.coyote.BadRequestException;

/**
 *
 * @author Santiago Cuevas
 */
public interface PacienteService {

    List<Paciente> listarTodosLosPacientes();
   
    Paciente encontrarPorDocumento(String documento)throws BadRequestException;
            
}
