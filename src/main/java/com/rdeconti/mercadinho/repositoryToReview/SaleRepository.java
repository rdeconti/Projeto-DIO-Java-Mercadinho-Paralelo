package com.rdeconti.mercadinho.repositoryToReview;

import com.rdeconti.mercadinho.models.SaleModel;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<SaleModel, String> {

    public SaleModel findByCodigo(Integer codigo);

}
