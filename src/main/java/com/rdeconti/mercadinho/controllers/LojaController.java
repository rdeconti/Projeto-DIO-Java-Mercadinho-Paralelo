package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.Loja;
import com.rdeconti.mercadinho.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;
    
    @GetMapping
    public Iterable<Loja> listar(){
        return lojaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Loja loja){
        lojaService.inserir(loja);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody Loja loja){
        lojaService.alterar(loja);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        lojaService.excluir(id);
    }    
}
