package com.uem.loja.repository;

import org.springframework.data.repository.CrudRepository;

import com.uem.loja.models.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, String>{
	Fornecedor findByCodigo(long codigo);
}
