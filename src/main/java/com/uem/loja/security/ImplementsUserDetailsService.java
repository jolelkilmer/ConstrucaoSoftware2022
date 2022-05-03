package com.uem.loja.security;

import javax.transaction.Transactional;

import com.uem.loja.models.Funcionario;
import com.uem.loja.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository fr;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Funcionario funcionario = fr.findByCpf(cpf);

        if(funcionario == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new User(funcionario.getUsername(),funcionario.getPassword(),true,true,true,true, funcionario.getAuthorities());
    }
}
