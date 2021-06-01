package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.Estoque;
import com.rdeconti.mercadinho.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/price")
public class EstoqueController {
    
	@Autowired
    private EstoqueService estoqueService;
	
    @GetMapping
    public Iterable<Estoque> listar(){
        return estoqueService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Estoque estoque){
        estoqueService.inserir(estoque);
    }
    
    @PostMapping
    @RequestMapping("{codigoFilial}/{codigoProduto}/{quantidade}")
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@PathVariable Integer codigoFilial, @PathVariable Integer codigoProduto, @PathVariable Integer quantidade){
        Estoque estoque = estoqueService.findById( codigoFilial, codigoProduto );
    	estoqueService.inserir(estoque);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody Estoque estoque){
        estoqueService.alterar(estoque);
    }

    @DeleteMapping
    @RequestMapping("{codigoFilial}/{codigoProduto}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer codigoFilial, @PathVariable Integer codigoProduto){
        estoqueService.excluir(codigoFilial, codigoProduto);
    }
}
