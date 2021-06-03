package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, String> {

    public UserModel findByCodigo(Integer codigo);

}
