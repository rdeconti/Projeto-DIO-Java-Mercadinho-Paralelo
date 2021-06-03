package com.rdeconti.mercadinho.servicesToReview;

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
    private UserServiceSecurity userServiceSecurity;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        UserModel user = userServiceSecurity.findUserByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleModel> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (RoleModel role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(UserModel user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUser_name(), user.getUser_password(),
                user.getUser_status(), true, true, true, authorities);
    }
}
