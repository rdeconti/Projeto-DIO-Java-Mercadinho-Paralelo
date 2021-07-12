// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object USER
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.UserModel;
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

    // TODO REVIEW DOCUMENTATION

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
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
                userModel.getStatus(), true, true, true, authorities);
    }
}
