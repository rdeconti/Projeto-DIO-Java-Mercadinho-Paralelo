package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.StoreModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<StoreModel, String> {

    public StoreModel findByCodigo(Integer codigo);

}
