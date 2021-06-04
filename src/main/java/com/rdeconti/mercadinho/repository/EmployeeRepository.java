package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, String> {

    public EmployeeModel findByCodigo(Integer codigo);

}
