package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.stocker.MovementModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends PagingAndSortingRepository<MovementModel, Long>,
        JpaSpecificationExecutor<MovementModel> {
}