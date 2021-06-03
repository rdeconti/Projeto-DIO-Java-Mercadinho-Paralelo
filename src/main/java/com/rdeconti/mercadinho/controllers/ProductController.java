package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.ProductModel;
import com.rdeconti.mercadinho.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prroducts")
public class ProductController {

    @Autowired
    private ProductService prroductService;

    @GetMapping
    public Iterable<ProductModel> listar(){
        return prroductService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody ProductModel prroduct){
        prroductService.create(prroduct);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody ProductModel prroduct){
        prroductService.update(prroduct);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        prroductService.delete(id);
    }

}
