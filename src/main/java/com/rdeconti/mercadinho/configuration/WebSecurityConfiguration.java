// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Security configuration
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.configuration;

import com.rdeconti.mercadinho.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf()
            .disable()
            .authorizeRequests()
                .antMatchers("/role/manager").hasAuthority("ROLE_MANAGER")
                .antMatchers("/role/purchaser").hasAuthority("ROLE_PURCHASER")
                .antMatchers("/role/seller").hasAuthority("ROLE_SELLER")
                .antMatchers("/role/stocker").hasAuthority("ROLE_STOCKER")
                .antMatchers("/role/user").hasAuthority("ROLE_USER")
                .antMatchers("/").permitAll()
                .antMatchers("/authorization/login").permitAll()
                .antMatchers("/authorization/registration").permitAll()

                .anyRequest()
                .authenticated()

                .and()
                    .formLogin()
                    .loginPage("/authorization/login")
                    .failureUrl("/authorization/login?error=true")
                    .defaultSuccessUrl("/role/defaultAfterLogin")
                    .usernameParameter("userName")
                    .passwordParameter("password")

                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/authorization/logout"))
                    .logoutSuccessUrl("/authorization/login")

                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/authorization/authorization-noAccess");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
