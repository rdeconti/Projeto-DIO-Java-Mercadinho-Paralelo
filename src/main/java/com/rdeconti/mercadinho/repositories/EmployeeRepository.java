package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// -----------------------------------------------------------------------------------------------------------------
// Extension of CrudRepository to provide additional methods
// to retrieve entities using the pagination and sorting abstraction.
// -----------------------------------------------------------------------------------------------------------------
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeModel, Long>,
        JpaSpecificationExecutor<EmployeeModel> {
        // Interface to allow execution of Specifications based on the JPA criteria API.
}
