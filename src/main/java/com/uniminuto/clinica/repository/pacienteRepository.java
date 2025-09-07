package com.uniminuto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uniminuto.clinica.entity.Paciente;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByDocumento(String documento);
}

