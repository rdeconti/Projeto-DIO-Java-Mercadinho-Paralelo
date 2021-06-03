package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.StoreModel;
import com.rdeconti.mercadinho.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Iterable<StoreModel> findAll(){
        return storeRepository.findAll( );
    }

    public StoreModel findById(Integer store_ID) {
        return storeRepository.findByCodigo( store_ID );
    }

    public void create(StoreModel store){
        storeRepository.save( store );
        System.out.println("CREATION DONE WITH SUCCESS: " + store);
    }

    public void update(StoreModel store){
        storeRepository.save( store );
        System.out.println("UPDATE DONE WITH SUCCESS " + store);
    }

    public void delete(Integer store_ID){
        StoreModel store = storeRepository.findByCodigo( store_ID );
        storeRepository.delete( store );
        System.out.println("DELETE DONE WITH SUCCESS " + store);
    }

}