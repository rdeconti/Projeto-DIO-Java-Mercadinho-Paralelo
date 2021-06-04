package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.VendorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<VendorModel, String> {

    public VendorModel findByCodigo(Integer codigo);

}
