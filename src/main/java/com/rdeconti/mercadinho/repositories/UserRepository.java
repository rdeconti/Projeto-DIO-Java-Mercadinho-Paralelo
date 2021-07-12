// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Repository level that execute data persistence regarding object USER
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// -----------------------------------------------------------------------------------------------------------------
// Extension of CrudRepository to provide additional methods
// to retrieve entities using the pagination and sorting abstraction.
// -----------------------------------------------------------------------------------------------------------------
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel findByUserName(String userName);
    UserModel findRoleByUserName(String userRole);
    // Interface to allow execution of Specifications based on the JPA criteria API.
}