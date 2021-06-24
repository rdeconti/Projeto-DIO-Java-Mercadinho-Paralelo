package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.services.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/authorization/noAccess"}, method = RequestMethod.GET)
    public ModelAndView noAccess(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-noAccess");
        return modelAndView;
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView landingPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/landingPage");
        return modelAndView;
    }

    @RequestMapping(value={"/authorization/login"}, method = RequestMethod.GET)
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-login");
        return modelAndView;
    }

    @RequestMapping(value="/authorization/registration", method = RequestMethod.GET)
    public ModelAndView registration(){

        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("user", userModel);
        modelAndView.setViewName("/authorization/authorization-registration");
        return modelAndView;
    }

    @RequestMapping(value = "/authorization/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserModel userModel, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        UserModel userModelExists = userService.findUserByUserName(userModel.getUserName());

        if (userModelExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "Já existe um usuário com este nome de usuário. Escolha outro nome!");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/authorization/authorization-registration");

        } else {
            userService.saveUser(userModel);
            modelAndView.addObject("successMessage", "Conta cadastrada com sucesso!");
            modelAndView.addObject("user", new UserModel());
            modelAndView.setViewName("/authorization/authorization-registration");

        }
        return modelAndView;
    }
}
