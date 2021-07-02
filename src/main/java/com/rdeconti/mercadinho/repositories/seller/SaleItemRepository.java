package com.rdeconti.mercadinho.repositories.seller;

import com.rdeconti.mercadinho.models.seller.SaleItemModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository extends PagingAndSortingRepository<SaleItemModel, Long>,
        JpaSpecificationExecutor<SaleItemModel> {
}
