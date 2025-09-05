package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.entity.Paciente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Santiago Cuevas
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    Optional<Paciente> findByDocumento(String documento);
}
