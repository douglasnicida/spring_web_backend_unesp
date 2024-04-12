package br.com.cam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cam.api.model.AuthenticationDTO;
import br.com.cam.api.model.Fisica;
import br.com.cam.api.model.LoginResponseDTO;
import br.com.cam.api.model.RegisterDTO;
import br.com.cam.api.model.Usuario;
import br.com.cam.api.repository.UsuarioRepository;
import br.com.cam.security.TokenService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        // Armazenando as senhas dos usuarios em HASH no BD

        // É uma boa prática armazenarmos as senhas do usuário como HASH no banco de dados. 
        // Dessa maneira, caso haja um vazamento do BD, as senhas estarão criptografadas
        // e não poderão ser diretamente acessadas. 
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        try{
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((Usuario)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }catch(Exception e){
            System.out.println("Erro:  ");
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

     @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        // Primeiro verifica se já não existe outro usuário cadastrado com o mesmo login
        if(this.usuarioRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        // Caso não exista, vamos encriptar a senha para salvar no BD. A senha bruta do usuário 
        // NÃO DEVE SER INSERIDA NO BD POR MEDIDAS DE SEGURANÇA.


        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        System.out.println(data.login());
        System.out.println(encryptedPassword);
        System.out.println(data.role());

        Fisica newUser = new Fisica(data.login() ,encryptedPassword, data.role(), "teste", "testee");

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    

}
