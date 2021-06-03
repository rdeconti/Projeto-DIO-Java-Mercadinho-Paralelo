package com.rdeconti.mercadinho.servicesToReview;

import com.rdeconti.mercadinho.models.RoleModel;
import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.repository.RoleRepository;
import com.rdeconti.mercadinho.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceSecurity {

    private UserRepositoryJpa userRepositoryJpa;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceSecurity(UserRepositoryJpa userRepository,
                               RoleRepository roleRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepositoryJpa = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserModel findUserByEmail(String email) {
        return userRepositoryJpa.findByUser_Email(email);
    }

    public UserModel findUserByUserName(String userName) {
        return userRepositoryJpa.findByUser_Name(userName);
    }

    public UserModel saveUser(UserModel user) {
        user.setUser_password(bCryptPasswordEncoder.encode(user.getUser_password()));
        user.setUser_status(true);
        RoleModel userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<RoleModel>(Arrays.asList(userRole)));
        return userRepositoryJpa.save(user);
    }

}