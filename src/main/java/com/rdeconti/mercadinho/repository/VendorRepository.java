package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.VendorModel;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<VendorModel, String> {

    public VendorModel findByCodigo(Integer codigo);

}
