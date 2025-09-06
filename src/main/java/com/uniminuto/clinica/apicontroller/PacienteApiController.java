package com.uniminuto.clinica.apicontroller;

import com.uniminuto.clinica.api.PacienteApi;
import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.model.RespuestaRs;
import com.uniminuto.clinica.service.PacienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador API para la entidad Paciente
 * @author lmora
 */
@RestController
public class PacienteApiController implements PacienteApi {

    @Autowired
    private PacienteService pacienteService;

    @Override
    public ResponseEntity<List<Paciente>> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @Override
    public ResponseEntity<List<Paciente>> obtenerPacientesActivos() {
        List<Paciente> pacientes = pacienteService.obtenerPacientesActivos();
        return ResponseEntity.ok(pacientes);
    }

    @Override
    public ResponseEntity<RespuestaRs> buscarPacientePorDocumento(String numeroDocumento) {
        RespuestaRs respuesta = new RespuestaRs();
        
        try {
            Optional<Paciente> paciente = pacienteService.buscarPorNumeroDocumento(numeroDocumento);
            
            if (paciente.isPresent()) {
                respuesta.setStatus(200);
                respuesta.setMensaje("Paciente encontrado: " + paciente.get().getNombres() + " " + paciente.get().getApellidos());
            } else {
                respuesta.setStatus(404);
                respuesta.setMensaje("No se encontró ningún paciente con el documento: " + numeroDocumento);
            }
        } catch (Exception e) {
            respuesta.setStatus(500);
            respuesta.setMensaje("Error al buscar paciente: " + e.getMessage());
        }
        
        return ResponseEntity.ok(respuesta);
    }

    @Override
    public ResponseEntity<List<Paciente>> buscarPacientesPorNombre(String nombre) {
        List<Paciente> pacientes = pacienteService.buscarPorNombre(nombre);
        return ResponseEntity.ok(pacientes);
    }
}
