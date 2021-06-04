package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.SaleModel;
import com.rdeconti.mercadinho.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Iterable<SaleModel> findAll(){
        return saleRepository.findAll( );
    }

    public SaleModel findById(Integer sale_ID) {
        return saleRepository.findByCodigo( sale_ID );
    }

    public void create(SaleModel sale){
        saleRepository.save( sale );
        System.out.println("CREATION DONE WITH SUCCESS: " + sale);
    }

    public void update(SaleModel sale){
        saleRepository.save( sale );
        System.out.println("UPDATE DONE WITH SUCCESS " + sale);
    }

    public void delete(Integer sale_ID){
        SaleModel sale = saleRepository.findByCodigo( sale_ID );
        saleRepository.delete( sale );
        System.out.println("DELETE DONE WITH SUCCESS " + sale);
    }

}
