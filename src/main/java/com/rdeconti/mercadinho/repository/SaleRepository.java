package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.SaleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<SaleModel, String> {

    public SaleModel findByCodigo(Integer codigo);

}
