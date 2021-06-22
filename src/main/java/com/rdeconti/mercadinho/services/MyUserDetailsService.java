package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.manager.RoleModel;
import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.services.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {

        UserModel userModel = userService.findUserByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(userName);
        return buildUserForAuthentication(userModel, authorities);

    }

    private List<GrantedAuthority> getUserAuthority(String userName) {

        Set<GrantedAuthority> roles = new HashSet<>();
        UserModel userModel = userService.findRoleByUserName(userName);
        roles.add(new SimpleGrantedAuthority(userModel.getRole()));
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(UserModel userModel, List<GrantedAuthority> authorities) {

        return new org.springframework.security.core.userdetails.User(userModel.getUserName(), userModel.getPassword(),
                userModel.getActive(), true, true, true, authorities);
    }
}
