package br.com.cam.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Juridica")
public class Juridica extends Usuario {
    private int reputacao;
    private String nomeEmpresa;
    private String cnpj;

    public int getReputacao() {
        return reputacao;
    }
    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
