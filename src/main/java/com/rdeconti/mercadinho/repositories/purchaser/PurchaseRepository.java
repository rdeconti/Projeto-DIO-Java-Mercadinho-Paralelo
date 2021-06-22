package com.rdeconti.mercadinho.repositories.purchaser;

import com.rdeconti.mercadinho.models.purchaser.PurchaseModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends PagingAndSortingRepository<PurchaseModel, Long>,
        JpaSpecificationExecutor<PurchaseModel> {
}