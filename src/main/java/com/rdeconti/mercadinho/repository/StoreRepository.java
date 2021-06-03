package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.StoreModel;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreModel, String> {

    public StoreModel findByCodigo(Integer codigo);

}
