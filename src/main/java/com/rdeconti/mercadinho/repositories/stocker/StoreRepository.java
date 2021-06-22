package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.stocker.StoreModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<StoreModel, Long>,
        JpaSpecificationExecutor<StoreModel> {
}
