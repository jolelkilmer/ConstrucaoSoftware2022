package com.uem.loja.repository;

import com.uem.loja.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
	Funcionario findByCodigo(long codigo);

    Funcionario findByCpf(String cpf);
}
