package com.uniminuto.clinica.apicontroller;

import com.uniminuto.clinica.api.UsuarioApi;
import com.uniminuto.clinica.entity.Usuario;
import com.uniminuto.clinica.model.RespuestaRs;
import com.uniminuto.clinica.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador API para la entidad Usuario
 * @author lmora
 */
@RestController
public class UsuarioApiController implements UsuarioApi {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ResponseEntity<RespuestaRs> buscarUsuarioPorDocumento(String numeroDocumento) {
        RespuestaRs respuesta = new RespuestaRs();
        
        try {
            Optional<Usuario> usuario = usuarioService.buscarPorNumeroDocumento(numeroDocumento);
            
            if (usuario.isPresent()) {
                Usuario user = usuario.get();
                respuesta.setStatus(200);
                respuesta.setMensaje("Usuario encontrado: " + user.getUsername() + 
                                  " - Rol: " + user.getRol() + 
                                  " - Activo: " + (user.isActivo() ? "Sí" : "No"));
            } else {
                respuesta.setStatus(404);
                respuesta.setMensaje("No se encontró ningún usuario con el documento: " + numeroDocumento);
            }
        } catch (Exception e) {
            respuesta.setStatus(500);
            respuesta.setMensaje("Error al buscar usuario: " + e.getMessage());
        }
        
        return ResponseEntity.ok(respuesta);
    }
}