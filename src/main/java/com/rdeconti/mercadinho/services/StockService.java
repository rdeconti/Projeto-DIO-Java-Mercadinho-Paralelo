package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.StockModel;
import com.rdeconti.mercadinho.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository StockRepository;

    public Iterable<StockModel> findAll(){
        return StockRepository.findAll( );
    }

    public StockModel findById(Integer Stock_ID) {
        return StockRepository.findByCodigo( Stock_ID );
    }

    public void create(StockModel Stock){
        StockRepository.save( Stock );
        System.out.println("CREATION DONE WITH SUCCESS: " + Stock);
    }

    public void update(StockModel Stock){
        StockRepository.save( Stock );
        System.out.println("UPDATE DONE WITH SUCCESS " + Stock);
    }

    public void delete(Integer Stock_ID){
        StockModel Stock = StockRepository.findByCodigo( Stock_ID );
        StockRepository.delete( Stock );
        System.out.println("DELETE DONE WITH SUCCESS " + Stock);
    }

}