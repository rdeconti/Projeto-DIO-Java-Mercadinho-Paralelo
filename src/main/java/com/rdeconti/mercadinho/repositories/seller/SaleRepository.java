package com.rdeconti.mercadinho.repositories.seller;

import com.rdeconti.mercadinho.models.seller.SaleModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends PagingAndSortingRepository<SaleModel, Long>,
        JpaSpecificationExecutor<SaleModel> {
}
