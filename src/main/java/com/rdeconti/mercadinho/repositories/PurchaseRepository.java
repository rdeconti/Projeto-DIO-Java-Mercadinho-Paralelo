package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.PurchaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseModel, String> {

    public PurchaseModel findByCodigo(Integer codigo);

}
