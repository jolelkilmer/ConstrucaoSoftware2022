package com.uem.loja.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario implements UserDetails {
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	private String nome_completo;
	private String telefone;
	private String rua;
	private String bairro;
	private String numero_casa;
	private String cpf;
    private String cargo;
	private String senha;

	@ManyToMany
    @JoinTable(name = "funcionario_roles",joinColumns = @JoinColumn(
            name="funcionario_id", referencedColumnName = "cpf"),
            inverseJoinColumns = @JoinColumn(
            name="role_id", referencedColumnName="nomeRole"))
    private List<Role> roles;


    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

}
