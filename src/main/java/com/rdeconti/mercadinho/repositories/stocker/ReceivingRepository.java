package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.stocker.ReceivingModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingRepository extends PagingAndSortingRepository<ReceivingModel, Long>,
        JpaSpecificationExecutor<ReceivingModel> {
}
