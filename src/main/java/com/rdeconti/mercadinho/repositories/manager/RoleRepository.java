package com.rdeconti.mercadinho.repositories.manager;

import com.rdeconti.mercadinho.models.manager.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    RoleModel findByRole(String role);

}
