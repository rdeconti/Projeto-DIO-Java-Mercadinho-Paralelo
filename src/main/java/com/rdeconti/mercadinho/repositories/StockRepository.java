package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.StockModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<StockModel, String> {

    public StockModel findByCodigo(Integer codigo);

}
