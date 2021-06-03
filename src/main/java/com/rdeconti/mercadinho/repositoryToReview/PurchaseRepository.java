package com.rdeconti.mercadinho.repositoryToReview;

import com.rdeconti.mercadinho.models.PurchaseModel;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<PurchaseModel, String> {

    public PurchaseModel findByCodigo(Integer codigo);

}
