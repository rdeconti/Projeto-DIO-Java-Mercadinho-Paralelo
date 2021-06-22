package com.rdeconti.mercadinho.repositories.manager;

import com.rdeconti.mercadinho.models.manager.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel findByUserName(String userName);
    UserModel findRoleByUserName(String userRole);
}