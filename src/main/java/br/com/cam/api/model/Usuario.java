package br.com.cam.api.model;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private String email;

    public Usuario(Long id, String nome, String senha, String email){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
