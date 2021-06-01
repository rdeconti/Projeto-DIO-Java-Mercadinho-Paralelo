package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.Preco;
import com.rdeconti.mercadinho.services.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/itens")
public class PrecoController {
    
	@Autowired
    private PrecoService precoService;
	
    @GetMapping
    public Iterable<Preco> listar(){
        return precoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Preco preco){
        precoService.inserir(preco);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody Preco preco){
        precoService.alterar(preco);
    }

}
