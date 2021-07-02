package com.rdeconti.mercadinho.repositories.stocker;

import com.rdeconti.mercadinho.models.stocker.ImageModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<ImageModel, Long>,
        JpaSpecificationExecutor<ImageModel> {
}
