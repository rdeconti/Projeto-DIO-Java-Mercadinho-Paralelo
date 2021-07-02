package com.rdeconti.mercadinho.repositories.manager;

import com.rdeconti.mercadinho.models.manager.EmployeeModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeModel, Long>,
        JpaSpecificationExecutor<EmployeeModel> {
}
