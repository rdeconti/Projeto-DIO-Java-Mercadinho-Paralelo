package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.services.AgendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AgendaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 5;

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value={"/agenda/index"}, method = RequestMethod.GET)
    public ModelAndView index1(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value={"/contacts"}, method = RequestMethod.GET)
    public ModelAndView getContacts(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        List<AgendaModel> contacts = agendaService.findAll(pageNumber, ROW_PER_PAGE);

        long count = agendaService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("contacts", contacts);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-list");
        return modelAndView;

    }

    @RequestMapping(value={"/contacts/{contactId}"}, method = RequestMethod.GET)
    public ModelAndView getContactById(Model model, @PathVariable long contactId) {
        AgendaModel contact = null;
        try {
            contact = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("contact", contact);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @RequestMapping(value={"/contacts/add"}, method = RequestMethod.GET)
    public ModelAndView showAddContact(Model model) {
        AgendaModel contact = new AgendaModel();
        model.addAttribute("add", true);
        model.addAttribute("contact", contact);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-edit");
        return modelAndView;
    }

    @RequestMapping(value={"/contacts/add"}, method = RequestMethod.POST)
    public ModelAndView addContact(Model model,
                             @ModelAttribute("contact") AgendaModel contact) {
        try {
            AgendaModel newContact = agendaService.save(contact);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/contacts/" + String.valueOf(newContact.getId()));
            return modelAndView;


        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            //model.addAttribute("contact", contact);
            model.addAttribute("add", true);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("contact-edit");
            return modelAndView;

        }
    }

    @RequestMapping(value={"/contacts/{contactId}/edit"}, method = RequestMethod.GET)
    public ModelAndView showEditContact(Model model, @PathVariable long contactId) {
        AgendaModel contact = null;
        try {
            contact = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("contact", contact);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-edit");
        return modelAndView;
    }

    @RequestMapping(value={"/contacts/{contactId}/edit"}, method = RequestMethod.POST)
    public ModelAndView updateContact(Model model,
                                @PathVariable long contactId,
                                @ModelAttribute("contact") AgendaModel contact) {
        try {
            contact.setId(contactId);
            agendaService.update(contact);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/contacts/" + String.valueOf(contact.getId()));
            return modelAndView;
        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("contact-edit");
            return modelAndView;
        }
    }

    @RequestMapping(value={"/contacts/{contactId}/delete"}, method = RequestMethod.GET)
    public ModelAndView showDeleteContactById(
            Model model, @PathVariable long contactId) {
        AgendaModel contact = null;
        try {
            contact = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("contact", contact);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @RequestMapping(value={"/contacts/{contactId}/delete"}, method = RequestMethod.POST)
    public ModelAndView deleteContactById(
            Model model, @PathVariable long contactId) {
        try {
            agendaService.deleteById(contactId);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/contacts/");
            return modelAndView;
        } catch (ResourceNotFoundException ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("contact");
            return modelAndView;
        }
    }
}
