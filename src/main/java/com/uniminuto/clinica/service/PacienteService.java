package com.uniminuto.clinica.service;

import com.uniminuto.clinica.entity.Paciente;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz del servicio para la entidad Paciente
 * @author lmora
 */
public interface PacienteService {
    
    /**
     * Obtiene todos los pacientes
     * @return Lista de todos los pacientes
     */
    List<Paciente> obtenerTodosLosPacientes();
    
    /**
     * Obtiene todos los pacientes activos
     * @return Lista de pacientes activos
     */
    List<Paciente> obtenerPacientesActivos();
    
    /**
     * Busca un paciente por número de documento
     * @param numeroDocumento Número de documento a buscar
     * @return Paciente encontrado o vacío
     */
    Optional<Paciente> buscarPorNumeroDocumento(String numeroDocumento);
    
    /**
     * Busca pacientes por nombre
     * @param nombre Nombre o parte del nombre a buscar
     * @return Lista de pacientes que coincidan
     */
    List<Paciente> buscarPorNombre(String nombre);
    
    /**
     * Guarda un paciente
     * @param paciente Paciente a guardar
     * @return Paciente guardado
     */
    Paciente guardarPaciente(Paciente paciente);
    
    /**
     * Obtiene un paciente por ID
     * @param id ID del paciente
     * @return Paciente encontrado o vacío
     */
    Optional<Paciente> obtenerPorId(Long id);
}
