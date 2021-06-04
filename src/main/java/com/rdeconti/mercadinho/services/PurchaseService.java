package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.PurchaseModel;
import com.rdeconti.mercadinho.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Iterable<PurchaseModel> findAll(){
        return purchaseRepository.findAll( );
    }

    public PurchaseModel findById(Integer purchase_ID) {
        return purchaseRepository.findByCodigo( purchase_ID );
    }

    public void create(PurchaseModel purchase){
        purchaseRepository.save( purchase );
        System.out.println("CREATION DONE WITH SUCCESS: " + purchase);
    }

    public void update(PurchaseModel purchase){
        purchaseRepository.save( purchase );
        System.out.println("UPDATE DONE WITH SUCCESS " + purchase);
    }

    public void delete(Integer purchase_ID){
        PurchaseModel purchase = purchaseRepository.findByCodigo( purchase_ID );
        purchaseRepository.delete( purchase );
        System.out.println("DELETE DONE WITH SUCCESS " + purchase);
    }

}
