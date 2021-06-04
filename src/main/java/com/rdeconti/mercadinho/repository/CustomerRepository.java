package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, String> {

    public CustomerModel findByCodigo(Integer codigo);

}
