package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.services.AgendaService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PurchaseController {

    private static final Logger log = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    private AgendaService agendaService;

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = {"/purchaser/index"})
    public ModelAndView purchaseIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-index");
        return modelAndView;

    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/purchaser/purchase-list")
    public ModelAndView purchaseListAll(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<AgendaModel> agendas = agendaService.findAll(pageNumber, ROW_PER_PAGE);

        long count = agendaService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("agendas", agendas);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-list");
        return modelAndView;

    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/purchaser/purchase-list/{agendaId}")
    public ModelAndView purchaseListById(Model model,
                                 @PathVariable long agendaId) {

        AgendaModel agenda = null;

        try {
            agenda = agendaService.findById(agendaId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");

        }

        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-list");
        return modelAndView;

    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = {"/purchaser/purchase/create"})
    public ModelAndView purchaseCreateGet(Model model) {

        AgendaModel agenda = new AgendaModel();

        model.addAttribute("add", true);
        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-create");
        return modelAndView;
    }

    //------------------------------------------------------------------------------------------------------------------
    @PostMapping(value = "/purchaser/purchase/create")
    public ModelAndView purchaseCreatePost(Model model,
                                   @ModelAttribute("agenda") AgendaModel agenda) {

        try {

            AgendaModel newAgendaModel = agendaService.save(agenda);

            ModelAndView modelAndView = new ModelAndView();
            //modelAndView.setViewName("redirect:/purchaser/purchase-list/" + String.valueOf(newAgendaModel.getId()));
            modelAndView.setViewName("redirect:/purchaser/purchase-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchase-update");
            return modelAndView;

        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = {"/purchaser/purchase-update/{agendaId}"})
    public ModelAndView purchaseUpdateGet(Model model,
                                        @PathVariable long agendaId) {

        AgendaModel agenda = null;

        try {
            agenda = agendaService.findById(agendaId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "AgendaModel not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-update");
        return modelAndView;
    }

    //------------------------------------------------------------------------------------------------------------------
    @PostMapping(value = {"/purchaser/purchase-update/{agendaId}"})
    public ModelAndView purchaseUpdatePost(Model model,
                                        @PathVariable long agendaId,
                                        @ModelAttribute("agenda") AgendaModel agenda) {

        try {

            agenda.setId(agendaId);
            agendaService.update(agenda);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaser/purchase-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchase-update");
            return modelAndView;

        }
    }

    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = {"/purchaser/purchase-delete/{agendaId}"})
    public ModelAndView purchaseDeleteGet(Model model,
                                        @PathVariable long agendaId) {

        AgendaModel agenda = null;

        try {
            agenda = agendaService.findById(agendaId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchase-delete");
        return modelAndView;
    }

    //------------------------------------------------------------------------------------------------------------------
    @PostMapping(value = {"/purchaser/purchase-delete/{agendaId}"})
    public ModelAndView purchaseDeletePost(Model model,
                                    @PathVariable long agendaId) {

        try {

            agendaService.deleteById(agendaId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaser/purchase-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchase-delete");
            return modelAndView;

        }
    }
}
