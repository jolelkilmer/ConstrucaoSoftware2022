package com.uem.loja.repository;

import org.springframework.data.repository.CrudRepository;

import com.uem.loja.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	Cliente findByCodigo(long codigo);
}
