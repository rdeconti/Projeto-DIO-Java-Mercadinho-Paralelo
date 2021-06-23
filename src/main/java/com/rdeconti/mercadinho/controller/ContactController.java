package com.rdeconti.mercadinho.controller;

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
public class ContactController {

    private static final Logger log = Logger.getLogger(ContactController.class.getName());

    @Autowired
    private ContactService contactService;

    @GetMapping(value = {"/contact/index"})
    public ModelAndView contactIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-index");
        return modelAndView;

    }

    @GetMapping(value = "/contact/contact-list")
    public ModelAndView contactListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<ContactModel> contacts = contactService.findAll(pageNumber, ROW_PER_PAGE);

        long count = contactService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", contacts);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-list");
        return modelAndView;

    }

    @GetMapping(value = "/contact/contact-list/{contactId}")
    public ModelAndView contactListById(Model model,
                                       @PathVariable long contactId) {

        ContactModel contact = null;

        try {
            contact = contactService.findById(contactId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", contact);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-list");
        return modelAndView;

    }

    @GetMapping(value = {"/contact/contact-create"})
    public ModelAndView contactCreateGet(Model model) {

        ContactModel contact = new ContactModel();

        model.addAttribute("add", true);
        model.addAttribute("object", contact);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-create");
        return modelAndView;
    }

    @PostMapping(value = "/contact/contact-create")
    public ModelAndView contactCreatePost(Model model,
                                         @ModelAttribute("contact") ContactModel contact) {

        try {

            ContactModel newContactModel = contactService.save(contact);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/contact-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/contact-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/contact/contact-update/{contactId}"})
    public ModelAndView contactUpdateGet(Model model,
                                        @PathVariable long contactId) {

        ContactModel contact = null;

        try {
            contact = contactService.findById(contactId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", contact);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-update");
        return modelAndView;
    }

    @PostMapping(value = {"/contact/contact-update/{contactId}"})
    public ModelAndView contactUpdatePost(Model model,
                                         @PathVariable long contactId,
                                         @ModelAttribute("contact") ContactModel contact) {

        try {

            contact.setId(contactId);
            contactService.update(contact);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/contact-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/contact-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/contact/contact-delete/{contactId}"})
    public ModelAndView contactDeleteGet(Model model,
                                        @PathVariable long contactId) {

        ContactModel contact = null;

        try {
            contact = contactService.findById(contactId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", contact);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/contact-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/contact/contact-delete/{contactId}"})
    public ModelAndView contactDeletePost(Model model,
                                         @PathVariable long contactId) {

        try {

            contactService.deleteById(contactId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/contact-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/contact-delete");
            return modelAndView;

        }
    }
}