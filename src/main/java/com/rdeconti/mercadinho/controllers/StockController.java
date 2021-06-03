package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.StockModel;
import com.rdeconti.mercadinho.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    private StockService StockService;

    @GetMapping
    public Iterable<StockModel> listar(){
        return StockService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody StockModel Stock){
        StockService.create(Stock);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody StockModel Stock){
        StockService.update(Stock);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        StockService.delete(id);
    }

}
