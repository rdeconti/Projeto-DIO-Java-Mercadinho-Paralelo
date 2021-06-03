package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.VendorModel;
import com.rdeconti.mercadinho.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public Iterable<VendorModel> listar(){
        return vendorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody VendorModel vendor){
        vendorService.create(vendor);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody VendorModel vendor){
        vendorService.update(vendor);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        vendorService.delete(id);
    }

}
