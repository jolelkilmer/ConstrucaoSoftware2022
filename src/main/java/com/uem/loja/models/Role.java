package com.uem.loja.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

    @Id
    private String nomeRole;

    @ManyToMany
    private List<Funcionario> funcionarios;

    public String getNomeRole() {
        return this.nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }


    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
    
}
