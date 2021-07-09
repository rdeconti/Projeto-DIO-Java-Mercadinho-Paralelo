package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.services.manager.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Api(value="Mercadinho Paralelo - Role Controller")
@Controller
@Validated
public class RoleController {

    private static final String ATTRIBUTE_USER_NAME = "userName";
    private static final String ATTRIBUTE_ADMIN_MESSAGE = "adminMessage";
    private static final String ATTRIBUTE_USER_MESSAGE = "Seja bem-vindo(a)! ";
    private static final String ATTRIBUTE_ROLE_MANAGER = "Conteúdo disponível para ROLE-MANAGER";
    private static final String ATTRIBUTE_ROLE_PURCHASER = "Conteúdo disponível para ROLE-PURCHASER";
    private static final String ATTRIBUTE_ROLE_SELLER = "Conteúdo disponível para ROLE-SELLER";
    private static final String ATTRIBUTE_ROLE_STOCKER = "Conteúdo disponível para ROLE-STOCKER";


    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private UserService userService;

    // -----------------------------------------------------------------------------------------------------------------
    // Authorization: role DEFAULT after authorized Login (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value= {"/role/defaultAfterLogin"}, method = RequestMethod.GET)
    public String defaultAfterLogin() {

        Collection<? extends GrantedAuthority> authorities;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        authorities = authentication.getAuthorities();

        String myRole = authorities.toArray()[0].toString();

        // Treat user role and give authorized forms
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

    // -----------------------------------------------------------------------------------------------------------------
    // Authorization: role MANAGER after authorized Login (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/role/manager", method = RequestMethod.GET)
    public ModelAndView manager(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject(ATTRIBUTE_USER_NAME, ATTRIBUTE_USER_MESSAGE + userModel.getFullName());
        modelAndView.addObject(ATTRIBUTE_ADMIN_MESSAGE,ATTRIBUTE_ROLE_MANAGER);
        modelAndView.setViewName("managerRole/manager-index");

        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Authorization: role PURCHASER after authorized Login (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/role/purchaser", method = RequestMethod.GET)
    public ModelAndView purchaser(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject(ATTRIBUTE_USER_NAME, ATTRIBUTE_USER_MESSAGE + userModel.getFullName());
        modelAndView.addObject(ATTRIBUTE_ADMIN_MESSAGE,ATTRIBUTE_ROLE_PURCHASER);
        modelAndView.setViewName("purchaserRole/purchaser-index");

        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Authorization: role SELLER after authorized Login (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/role/seller", method = RequestMethod.GET)
    public ModelAndView seller(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject(ATTRIBUTE_USER_NAME, ATTRIBUTE_USER_MESSAGE + userModel.getFullName());
        modelAndView.addObject(ATTRIBUTE_ADMIN_MESSAGE,ATTRIBUTE_ROLE_SELLER);
        modelAndView.setViewName("sellerRole/seller-index");

        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Authorization: role STOCKER after authorized Login (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/role/stocker", method = RequestMethod.GET)
    public ModelAndView stocker(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject(ATTRIBUTE_USER_NAME, ATTRIBUTE_USER_MESSAGE + userModel.getFullName());
        modelAndView.addObject(ATTRIBUTE_ADMIN_MESSAGE,ATTRIBUTE_ROLE_STOCKER);
        modelAndView.setViewName("stockerRole/stocker-index");

        return modelAndView;
    }
}
