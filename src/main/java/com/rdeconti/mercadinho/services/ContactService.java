package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.ContactModel;
import com.rdeconti.mercadinho.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Iterable<ContactModel> findAll(){
        return contactRepository.findAll( );
    }

    public ContactModel findById(Integer ID) {
        return contactRepository.findByCodigo( ID );
    }

    public void create(ContactModel contact){
        contactRepository.save( contact );
        System.out.println("CREATION DONE WITH SUCCESS: " + contact);
    }

    public void update(ContactModel contact){
        contactRepository.save( contact );
        System.out.println("UPDATE DONE WITH SUCCESS " + contact);
    }

    public void delete(Integer contact_ID){
        ContactModel contact = contactRepository.findByCodigo( contact_ID );
        contactRepository.delete( contact );
        System.out.println("DELETE DONE WITH SUCCESS " + contact);
    }

}
