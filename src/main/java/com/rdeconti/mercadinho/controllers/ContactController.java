package com.rdeconti.mercadinho.controllers;

import com.rdeconti.mercadinho.models.ContactModel;
import com.rdeconti.mercadinho.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public Iterable<ContactModel> listar(){
        return contactService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody ContactModel contact){
        contactService.create(contact);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody ContactModel contact){
        contactService.update(contact);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Integer id){
        contactService.delete(id);
    }

}
