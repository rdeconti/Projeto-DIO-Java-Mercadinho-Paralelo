package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    RoleModel findByRole(String role);

}
