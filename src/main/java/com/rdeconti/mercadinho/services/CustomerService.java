package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.CustomerModel;
import com.rdeconti.mercadinho.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<CustomerModel> findAll(){
        return customerRepository.findAll( );
    }

    public CustomerModel findById(Integer customer_ID) {
        return customerRepository.findByCodigo( customer_ID );
    }

    public void create(CustomerModel customer){
        customerRepository.save( customer );
        System.out.println("CREATION DONE WITH SUCCESS: " + customer);
    }

    public void update(CustomerModel customer){
        customerRepository.save( customer );
        System.out.println("UPDATE DONE WITH SUCCESS " + customer);
    }

    public void delete(Integer customer_ID){
        CustomerModel customer = customerRepository.findByCodigo( customer_ID );
        customerRepository.delete( customer );
        System.out.println("DELETE DONE WITH SUCCESS " + customer);
    }

}
