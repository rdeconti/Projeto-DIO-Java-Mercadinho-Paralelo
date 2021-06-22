package com.rdeconti.mercadinho.services.manager;

import com.rdeconti.mercadinho.models.manager.RoleModel;
import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.repositories.manager.RoleRepository;
import com.rdeconti.mercadinho.repositories.manager.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

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
        userModel.setActive(true);
        // TODO REVIEW
        // RoleModel userRoleModel = roleRepository.findByRole("ROLE_USER");
        // userModel.setRoleModels(new HashSet<RoleModel>(Arrays.asList(userRoleModel)));
        userRepository.save(userModel);
    }

}