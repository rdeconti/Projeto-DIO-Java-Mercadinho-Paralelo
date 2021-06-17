package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.services.UserService;
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

    @RequestMapping(value={"/noAccess"}, method = RequestMethod.GET)
    public ModelAndView noAccess(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("noAccess");
        return modelAndView;
    }

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("user", userModel);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserModel userModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModelExists = userService.findUserByUserName(userModel.getUserName());
        if (userModelExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "Já existe um usuário com este nome de usuário. Escolha outro nome!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(userModel);
            modelAndView.addObject("successMessage", "Conta cadastrada com sucesso!");
            modelAndView.addObject("user", new UserModel());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value= {"/defaultAfterLogin"}, method = RequestMethod.GET)
    public String defaultAfterLogin() {

        Collection<? extends GrantedAuthority> authorities;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authorities = authentication.getAuthorities();
        String myRole = authorities.toArray()[0].toString();

        switch(myRole) {

            case "ROLE_CUSTOMER":
                return "redirect:/customer/customer";

            case "ROLE_MANAGER":
                return "redirect:/manager/manager";

            case "ROLE_PURCHASER":
                return "redirect:/purchaser/purchaser";

            case "ROLE_RECEIVER":
                return "redirect:/receiver/receiver";

            case "ROLE_SELLER":
                return "redirect:/seller/seller";

            case "ROLE_SHIPPER":
                return "redirect:/shipper/shipper";

            case "ROLE_STOCKHOLDER":
                return "redirect:/stockholder/stockholder";

            case "ROLE_USER":
                return "redirect:/user/user";

            case "ROLE_VENDOR":
                return "redirect:/vendor/vendor";

            default:
                return "redirect:/noAccess/noAccess";

        }

    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home2(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authorities = authentication.getAuthorities();
        String myRole = authorities.toArray()[0].toString();

        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para " + myRole);

        modelAndView.setViewName("admin/home");

        return modelAndView;
    }

    @RequestMapping(value="/manager/manager", method = RequestMethod.GET)
    public ModelAndView manager(){

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserModel userModel = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-MANAGER");
        modelAndView.setViewName("manager/manager");

        return modelAndView;
    }

    @RequestMapping(value="/customer/customer", method = RequestMethod.GET)
    public ModelAndView customer(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-CUSTOMER");
        modelAndView.setViewName("customer/customer");
        return modelAndView;
    }

    @RequestMapping(value="/vendor/vendor", method = RequestMethod.GET)
    public ModelAndView vendor(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-VENDOR");
        modelAndView.setViewName("vendor/vendor");
        return modelAndView;
    }

    @RequestMapping(value="/shipper/shipper", method = RequestMethod.GET)
    public ModelAndView shipper(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SHIPPER");
        modelAndView.setViewName("shipper/shipper");
        return modelAndView;
    }

    @RequestMapping(value="/receiver/receiver", method = RequestMethod.GET)
    public ModelAndView receiver(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-RECEIVER");
        modelAndView.setViewName("receiver/receiver");
        return modelAndView;
    }

    @RequestMapping(value="/purchaser/purchaser", method = RequestMethod.GET)
    public ModelAndView purchaser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("purchaser/purchaser-index");
        return modelAndView;
    }

    @RequestMapping(value="/seller/seller", method = RequestMethod.GET)
    public ModelAndView seller(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SELLER");
        modelAndView.setViewName("seller/seller");
        return modelAndView;
    }

    @RequestMapping(value="/stockholder/stockholder", method = RequestMethod.GET)
    public ModelAndView stockholder(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-STOCKHOLDER");
        modelAndView.setViewName("stockholder/stockholder");
        return modelAndView;
    }

    @RequestMapping(value="/user/user", method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-USER");
        modelAndView.setViewName("user/user");
        return modelAndView;
    }

}
