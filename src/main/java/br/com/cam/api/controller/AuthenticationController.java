package br.com.cam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cam.api.model.AuthenticationDTO;
import br.com.cam.api.model.RegisterDTO;
import br.com.cam.api.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        // Armazenando as senhas dos usuarios em HASH no BD

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println(usernamePassword);
        try{
            var auth = this.authenticationManager.authenticate(usernamePassword);
        } catch(Exception e){
            System.out.println("Erro:   ");
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println(usernamePassword);
        try{
            var auth = this.authenticationManager.authenticate(usernamePassword);
        } catch(Exception e){
            System.out.println("Erro:   ");
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

}
