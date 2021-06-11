package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.RoleModel;
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

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        UserModel userModel = userService.findUserByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(userModel.getRoleModels());
        return buildUserForAuthentication(userModel, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleModel> userRoleModels) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (RoleModel roleModel : userRoleModels) {
            roles.add(new SimpleGrantedAuthority(roleModel.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(UserModel userModel, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(userModel.getUserName(), userModel.getPassword(),
                userModel.getActive(), true, true, true, authorities);
    }
}
