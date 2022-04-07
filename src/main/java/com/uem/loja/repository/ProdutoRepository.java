package com.uem.loja.repository;

import com.uem.loja.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
    Produto findById(long id);
}
