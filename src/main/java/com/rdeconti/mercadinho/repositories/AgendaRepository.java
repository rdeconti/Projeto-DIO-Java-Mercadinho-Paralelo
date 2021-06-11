package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.AgendaModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends PagingAndSortingRepository<AgendaModel, Long>,
        JpaSpecificationExecutor<AgendaModel> {
}
