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