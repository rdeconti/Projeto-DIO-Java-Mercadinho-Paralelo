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
public class PurchaseCrudListController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 5;

    @Autowired
    private AgendaService agendaService;

    @Value("${msg.title}")
    private String title;

    @GetMapping(value = {"/purchaser/index"})
    public ModelAndView index(Model model) {

        model.addAttribute("title", title);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchaser-index");
        return modelAndView;

    }

    @GetMapping(value = "/purchaser/agendas")
    public ModelAndView getAgendaModels(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

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
        modelAndView.setViewName("purchaser/purchaser-list");
        return modelAndView;

    }

    @GetMapping(value = "/purchaser/agendas/{agendaId}")
    public ModelAndView getAgendaModelById(Model model,
                                 @PathVariable long agendaId) {

        AgendaModel agenda = null;

        try {
            agenda = agendaService.findById(agendaId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");

        }

        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchaser");
        return modelAndView;

    }

    @GetMapping(value = {"/purchaser/agendas/add"})
    public ModelAndView showAddAgendaModel(Model model) {

        AgendaModel agenda = new AgendaModel();

        model.addAttribute("add", true);
        model.addAttribute("agenda", agenda);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaser/purchaser-edit");
        return modelAndView;
    }

    @PostMapping(value = "/purchaser/agendas/add")
    public ModelAndView addAgendaModel(Model model,
                                   @ModelAttribute("agenda") AgendaModel agenda) {

        try {

            AgendaModel newAgendaModel = agendaService.save(agenda);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaser/agendas/" + String.valueOf(newAgendaModel.getId())) ;
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            logger.error(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchaser-edit");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/agendas/{agendaId}/edit"})
    public ModelAndView showEditAgendaModel(Model model,
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
        modelAndView.setViewName("purchaser/purchaser-edit");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/agendas/{agendaId}/edit"})
    public ModelAndView updateAgendaModel(Model model,
                                        @PathVariable long agendaId,
                                        @ModelAttribute("agenda") AgendaModel agenda) {

        try {

            agenda.setId(agendaId);
            agendaService.update(agenda);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaser/agendas/" + String.valueOf(agenda.getId())) ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            logger.error(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchaser-edit");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/agendas/{agendaId}/delete"})
    public ModelAndView showDeleteAgendaModelById(Model model,
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
        modelAndView.setViewName("purchaser/purchaser");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/agendas/{agendaId}/delete"})
    public ModelAndView deleteAgendaModelById(Model model,
                                    @PathVariable long agendaId) {

        try {

            agendaService.deleteById(agendaId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaser/agendas") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            logger.error(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaser/purchaser");
            return modelAndView;

        }
    }
}
