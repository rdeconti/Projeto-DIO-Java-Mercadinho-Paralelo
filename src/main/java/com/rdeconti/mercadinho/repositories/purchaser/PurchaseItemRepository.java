package com.rdeconti.mercadinho.repositories.purchaser;

import com.rdeconti.mercadinho.models.purchaser.PurchaseItemModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepository extends PagingAndSortingRepository<PurchaseItemModel, Long>,
        JpaSpecificationExecutor<PurchaseItemModel> {
}
