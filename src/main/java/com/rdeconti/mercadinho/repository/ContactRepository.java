package com.rdeconti.mercadinho.repository;

import com.rdeconti.mercadinho.models.ContactModel;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactModel, String> {

    public ContactModel findByCodigo(Integer codigo);

}
