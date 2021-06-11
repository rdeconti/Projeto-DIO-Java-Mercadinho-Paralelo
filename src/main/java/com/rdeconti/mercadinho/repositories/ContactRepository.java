package com.rdeconti.mercadinho.repositories;

import com.rdeconti.mercadinho.models.ContactModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactModel, String> {

    public ContactModel findByCodigo(Integer codigo);

}
