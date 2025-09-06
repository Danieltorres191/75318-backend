package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.entity.Paciente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Paciente
 * @author lmora
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    /**
     * Busca un paciente por número de documento
     * @param numeroDocumento Número de documento a buscar
     * @return Paciente encontrado o vacío
     */
    Optional<Paciente> findByNumeroDocumento(String numeroDocumento);
    
    /**
     * Busca pacientes activos
     * @return Lista de pacientes activos
     */
    List<Paciente> findByActivoTrue();
    
    /**
     * Busca pacientes por tipo de documento
     * @param tipoDocumento Tipo de documento
     * @return Lista de pacientes con ese tipo de documento
     */
    List<Paciente> findByTipoDocumento(String tipoDocumento);
    
    /**
     * Busca pacientes por nombre (búsqueda parcial)
     * @param nombre Nombre o parte del nombre a buscar
     * @return Lista de pacientes que coincidan
     */
    @Query("SELECT p FROM Paciente p WHERE p.nombres LIKE %:nombre% OR p.apellidos LIKE %:nombre%")
    List<Paciente> buscarPorNombre(@Param("nombre") String nombre);
}
