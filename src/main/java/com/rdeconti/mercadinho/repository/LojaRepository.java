package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.Loja;
import org.springframework.data.repository.CrudRepository;

public interface LojaRepository extends CrudRepository<Loja, String>
{
	public Loja findByCodigo(Integer codigo);
}
