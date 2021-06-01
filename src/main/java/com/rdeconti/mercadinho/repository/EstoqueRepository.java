package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.Estoque;
import com.rdeconti.mercadinho.models.Loja;
import com.rdeconti.mercadinho.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepository extends CrudRepository<Estoque, String>
{
	public Estoque findByCodigoFilialAndCodigoProduto(Loja codigoFilial, Produto codigoProduto);
}
