package br.com.cam.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cam.api.model.Usuario;
import br.com.cam.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario/")
public class IndexController {
    
    @Autowired(required = false)
    private UsuarioRepository usuarioRepository;
    
    /*Servicos RESTful*/
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }
            
            
}
