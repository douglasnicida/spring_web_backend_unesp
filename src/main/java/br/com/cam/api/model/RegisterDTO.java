package br.com.cam.api.model;

public record RegisterDTO(String nome, String login, String password, UserRole role) {
    
}
