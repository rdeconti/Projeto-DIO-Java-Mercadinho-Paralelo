package com.rdeconti.mercadinho.services.manager;

import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.repositories.manager.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // CHECK IF E-MAIL ALREADY EXISTS ON DATABASE
    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserModel findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserModel findRoleByUserName(String userRole) {
        return userRepository.findRoleByUserName(userRole);
    }

    public void saveUser(UserModel userModel) {
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userModel.setStatus(true);
        userRepository.save(userModel);
    }

}