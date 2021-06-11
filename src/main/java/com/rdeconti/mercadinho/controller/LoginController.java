package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

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

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-MANAGER");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/manager", method = RequestMethod.GET)
    public ModelAndView manager(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("manager");
        return modelAndView;
    }

    @RequestMapping(value="/customer", method = RequestMethod.GET)
    public ModelAndView customer(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("customer");
        return modelAndView;
    }

    @RequestMapping(value="/vendor", method = RequestMethod.GET)
    public ModelAndView vendor(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("vendor");
        return modelAndView;
    }

    @RequestMapping(value="/shipper", method = RequestMethod.GET)
    public ModelAndView shipper(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("shipper");
        return modelAndView;
    }

    @RequestMapping(value="/receiver", method = RequestMethod.GET)
    public ModelAndView receiver(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("receiver");
        return modelAndView;
    }

    @RequestMapping(value="/purchaser", method = RequestMethod.GET)
    public ModelAndView purchaser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-PURCHASER");
        modelAndView.setViewName("purchaser");
        return modelAndView;
    }

    @RequestMapping(value="/seller", method = RequestMethod.GET)
    public ModelAndView seller(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SELLER");
        modelAndView.setViewName("seller");
        return modelAndView;
    }

    @RequestMapping(value="/stockholder", method = RequestMethod.GET)
    public ModelAndView stockholder(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SELLER");
        modelAndView.setViewName("stockholder");
        return modelAndView;
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Sinta-se em casa! " + userModel.getUserName() + "/" + userModel.getName() + " " + userModel.getLastName() + " (" + userModel.getEmail() + ")");
        modelAndView.addObject("adminMessage","Conteúdo disponível para ROLE-SELLER");
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
