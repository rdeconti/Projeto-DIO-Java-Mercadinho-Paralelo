// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Repository level that execute data persistence regarding object MOVEMENT
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.MovementModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// -----------------------------------------------------------------------------------------------------------------
// Extension of CrudRepository to provide additional methods
// to retrieve entities using the pagination and sorting abstraction.
// -----------------------------------------------------------------------------------------------------------------
@Repository
public interface MovementRepository extends PagingAndSortingRepository<MovementModel, Long>,
        JpaSpecificationExecutor<MovementModel> {
        // Interface to allow execution of Specifications based on the JPA criteria API.
}