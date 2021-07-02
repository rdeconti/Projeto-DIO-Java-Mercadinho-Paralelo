package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.purchaser.ProductModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel, Long>,
        JpaSpecificationExecutor<ProductModel> {
}
