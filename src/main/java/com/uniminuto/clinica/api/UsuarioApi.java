package com.uniminuto.clinica.api;

import com.uniminuto.clinica.model.RespuestaRs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz API para la entidad Usuario
 * @author lmora
 */
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public interface UsuarioApi {

    /**
     * Endpoint para buscar usuario por número de documento
     * @param numeroDocumento Número de documento a buscar
     * @return Usuario encontrado o mensaje de error
     */
    @RequestMapping(value = "/buscar-por-documento",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RespuestaRs> buscarUsuarioPorDocumento(@RequestParam String numeroDocumento);
}