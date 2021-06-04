package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.PurchaseModel;
import com.rdeconti.mercadinho.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public Iterable<PurchaseModel> listar(){
        return purchaseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody PurchaseModel purchase){
        purchaseService.create(purchase);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody PurchaseModel purchase){
        purchaseService.update(purchase);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        purchaseService.delete(id);
    }

}
