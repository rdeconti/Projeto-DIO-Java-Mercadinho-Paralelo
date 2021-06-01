package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.Preco;
import com.rdeconti.mercadinho.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface PrecoRepository extends CrudRepository<Preco, String>
{
	public Preco findByCodigoProduto(Produto codigoProduto);
}
