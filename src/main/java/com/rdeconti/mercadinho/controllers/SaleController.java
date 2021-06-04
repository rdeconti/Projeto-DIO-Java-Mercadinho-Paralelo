package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.SaleModel;
import com.rdeconti.mercadinho.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Iterable<SaleModel> listar(){
        return saleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody SaleModel sale){
        saleService.create(sale);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody SaleModel sale){
        saleService.update(sale);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        saleService.delete(id);
    }

}
