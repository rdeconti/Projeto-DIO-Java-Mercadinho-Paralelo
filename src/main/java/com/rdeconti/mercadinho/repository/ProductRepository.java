package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, String> {

    public ProductModel findByCodigo(Integer codigo);

}
