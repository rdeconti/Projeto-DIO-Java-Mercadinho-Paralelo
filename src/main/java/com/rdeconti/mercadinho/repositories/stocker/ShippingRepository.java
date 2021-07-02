package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.stocker.ShippingModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends PagingAndSortingRepository<ShippingModel, Long>,
        JpaSpecificationExecutor<ShippingModel> {
}
