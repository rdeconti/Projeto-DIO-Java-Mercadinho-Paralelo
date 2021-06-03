package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> findAll(){
        return userRepository.findAll( );
    }

    public UserModel findById(Integer user_ID) {
        return userRepository.findByCodigo( user_ID );
    }

    public void create(UserModel user){
        userRepository.save( user );
        System.out.println("CREATION DONE WITH SUCCESS: " + user);
    }

    public void update(UserModel user){
        userRepository.save( user );
        System.out.println("UPDATE DONE WITH SUCCESS " + user);
    }

    public void delete(Integer user_ID){
        UserModel user = userRepository.findByCodigo( user_ID );
        userRepository.delete( user );
        System.out.println("DELETE DONE WITH SUCCESS " + user);
    }

}