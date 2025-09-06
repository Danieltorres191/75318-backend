package com.uniminuto.clinica.api;

import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.model.RespuestaRs;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz API para la entidad Paciente
 * @author lmora
 */
@CrossOrigin(origins = "*")
@RequestMapping("/paciente")
public interface PacienteApi {

    /**
     * Endpoint para obtener todos los pacientes
     * @return Lista de todos los pacientes
     */
    @RequestMapping(value = "/todos",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Paciente>> obtenerTodosLosPacientes();

    /**
     * Endpoint para obtener pacientes activos
     * @return Lista de pacientes activos
     */
    @RequestMapping(value = "/activos",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Paciente>> obtenerPacientesActivos();

    /**
     * Endpoint para buscar paciente por número de documento
     * @param numeroDocumento Número de documento a buscar
     * @return Paciente encontrado o mensaje de error
     */
    @RequestMapping(value = "/buscar-por-documento",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RespuestaRs> buscarPacientePorDocumento(@RequestParam String numeroDocumento);

    /**
     * Endpoint para buscar pacientes por nombre
     * @param nombre Nombre o parte del nombre a buscar
     * @return Lista de pacientes que coincidan
     */
    @RequestMapping(value = "/buscar-por-nombre",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Paciente>> buscarPacientesPorNombre(@RequestParam String nombre);
}
