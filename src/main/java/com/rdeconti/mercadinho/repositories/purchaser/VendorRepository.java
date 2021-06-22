package com.rdeconti.mercadinho.repositories.purchaser;

import com.rdeconti.mercadinho.models.purchaser.VendorModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends PagingAndSortingRepository<VendorModel, Long>,
        JpaSpecificationExecutor<VendorModel> {
}
