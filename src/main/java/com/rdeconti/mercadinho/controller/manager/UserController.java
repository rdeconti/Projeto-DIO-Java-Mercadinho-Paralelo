package com.rdeconti.mercadinho.controller.manager;

import com.rdeconti.mercadinho.controller.purchaser.PurchaseController;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.ContactModel;
import com.rdeconti.mercadinho.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger log = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    private ContactService userService;

    @GetMapping(value = "/user/user-list")
    public ModelAndView userListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<ContactModel> users = userService.findAll(pageNumber, ROW_PER_PAGE);

        long count = userService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("users", users);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerRole/user-list");
        return modelAndView;

    }

    @GetMapping(value = "/user/user-list/{userId}")
    public ModelAndView userListById(Model model,
                                       @PathVariable long userId) {

        ContactModel user = null;

        try {
            user = userService.findById(userId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "ContactModel not found");

        }

        model.addAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerRole/user-list");
        return modelAndView;

    }

    @GetMapping(value = {"/user/user/create"})
    public ModelAndView userCreateGet(Model model) {

        ContactModel user = new ContactModel();

        model.addAttribute("add", true);
        model.addAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerRole/user-create");
        return modelAndView;
    }

    @PostMapping(value = "/user/user/create")
    public ModelAndView userCreatePost(Model model,
                                         @ModelAttribute("user") ContactModel user) {

        try {

            ContactModel newContactModel = userService.save(user);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/managerRole/user-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("managerRole/user-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/user/user-update/{userId}"})
    public ModelAndView userUpdateGet(Model model,
                                        @PathVariable long userId) {

        ContactModel user = null;

        try {
            user = userService.findById(userId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "ContactModel not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerRole/user-update");
        return modelAndView;
    }

    @PostMapping(value = {"/user/user-update/{userId}"})
    public ModelAndView userUpdatePost(Model model,
                                         @PathVariable long userId,
                                         @ModelAttribute("user") ContactModel user) {

        try {

            user.setId(userId);
            userService.update(user);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/managerRole/user-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("managerRole/user-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/user/user-delete/{userId}"})
    public ModelAndView userDeleteGet(Model model,
                                        @PathVariable long userId) {

        ContactModel user = null;

        try {
            user = userService.findById(userId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerRole/user-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/user/user-delete/{userId}"})
    public ModelAndView userDeletePost(Model model,
                                         @PathVariable long userId) {

        try {

            userService.deleteById(userId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/managerRole/user-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("managerRole/user-delete");
            return modelAndView;

        }
    }
}