package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.ContactModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<ContactModel, Long>,
        JpaSpecificationExecutor<ContactModel> {
}
