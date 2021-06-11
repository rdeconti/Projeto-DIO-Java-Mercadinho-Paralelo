package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, String> {

    public ProductModel findByCodigo(Integer codigo);

}
