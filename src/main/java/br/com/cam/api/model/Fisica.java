package br.com.cam.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Fisica")
public class Fisica extends Usuario {
    private String nome;
    private String sobrenome;

    public Fisica(){
        
    }

    public Fisica(String email, String senha, UserRole role, String nome, String sobrenome) {
        super.setEmail(email);
        super.setSenha(senha);
        super.setRole(role);
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    
}
