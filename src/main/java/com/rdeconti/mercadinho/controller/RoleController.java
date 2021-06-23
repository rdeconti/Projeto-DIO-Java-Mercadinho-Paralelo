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
public class RoleController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= {"/role/defaultAfterLogin"}, method = RequestMethod.GET)
    public String defaultAfterLogin() {

        Collection<? extends GrantedAuthority> authorities;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authorities = authentication.getAuthorities();
        String myRole = authorities.toArray()[0].toString();

        switch(myRole) {

            case "ROLE_MANAGER":
                return "redirect:/role/manager";

            case "ROLE_PURCHASER":
                return "redirect:/role/purchaser";

            case "ROLE_SELLER":
                return "redirect:/role/seller";

            case "ROLE_STOCKER":
                return "redirect:/role/stocker";

            default:
                return "redirect:/authorization/noAccess";

        }

    }

    @RequestMapping(value="/role/manager", method = RequestMethod.GET)
    public ModelAndView manager(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getUserName() + " " + userModel.getUserName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-MANAGER");
        modelAndView.setViewName("managerRole/manager-index");

        return modelAndView;
    }

    @RequestMapping(value="/role/purchaser", method = RequestMethod.GET)
    public ModelAndView purchaser(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + " / " + userModel.getUserName() + " " + userModel.getUserName() + " ( " + userModel.getEmail() + " )");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("purchaserRole/purchaser-index");

        return modelAndView;
    }

    @RequestMapping(value="/role/seller", method = RequestMethod.GET)
    public ModelAndView seller(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getUserName() + " " + userModel.getUserName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SELLER");
        modelAndView.setViewName("sellerRole/seller-index");

        return modelAndView;
    }

    @RequestMapping(value="/role/stocker", method = RequestMethod.GET)
    public ModelAndView stocker(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getUserName() + " " + userModel.getUserName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-STOCKER");
        modelAndView.setViewName("stockerRole/stocker-index");

        return modelAndView;
    }
}
