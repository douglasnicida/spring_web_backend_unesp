package br.com.cam.api.model;

public record RegisterDTO(String login, String password, UserRole role) {
    
}
