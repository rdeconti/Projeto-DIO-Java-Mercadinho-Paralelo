package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    public UserModel findByCodigo(Integer codigo);

}
