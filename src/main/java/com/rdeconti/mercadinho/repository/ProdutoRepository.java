package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String>
{
	public Produto findByCodigo(Integer codigo);
}
