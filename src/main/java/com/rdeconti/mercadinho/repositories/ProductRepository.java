package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.ProductModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// -----------------------------------------------------------------------------------------------------------------
// Extension of CrudRepository to provide additional methods
// to retrieve entities using the pagination and sorting abstraction.
// -----------------------------------------------------------------------------------------------------------------
@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel, Long>,
        JpaSpecificationExecutor<ProductModel> {
        // Interface to allow execution of Specifications based on the JPA criteria API.
}
