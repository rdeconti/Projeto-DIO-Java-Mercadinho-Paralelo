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

import java.util.List;

@Controller
public class PurchaseCrudController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 5;

    @Autowired
    private AgendaService agendaService;

    @Value("${msg.title}")
    private String title;

    ////// @GetMapping(value = {"/", "/index"})
    @GetMapping(value = {"/purchase/index"})
    public String index(Model model) {
        model.addAttribute("title", title);
        // return "index";
        return "purchase-index";
    }

    @GetMapping(value = "/purchase/agendas")
    public String getAgendaModels(Model model,
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
        // return "agenda-list";
        return "purchase-list";
    }

    @GetMapping(value = "/purchase/agendas/{agendaId}")
    public String getAgendaModelById(Model model, @PathVariable long agendaId) {
        AgendaModel agenda = null;
        try {
            agenda = agendaService.findById(agendaId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");
        }
        model.addAttribute("agenda", agenda);
        // return "agenda";
        return "purchase";
    }

    @GetMapping(value = {"/purchase/agendas/add"})
    public String showAddAgendaModel(Model model) {
        AgendaModel agenda = new AgendaModel();
        model.addAttribute("add", true);
        model.addAttribute("agenda", agenda);
        //return "agenda-edit";
        return "purchase-edit";
    }

    @PostMapping(value = "/purchase/agendas/add")
    public String addAgendaModel(Model model,
                             @ModelAttribute("agenda") AgendaModel agenda) {
        try {
            AgendaModel newAgendaModel = agendaService.save(agenda);
            return "redirect:/purchase/agendas/" + String.valueOf(newAgendaModel.getId());
        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            //model.addAttribute("agenda", agenda);
            model.addAttribute("add", true);
            //return "agenda-edit";
            return "purchase-edit";
        }
    }

    @GetMapping(value = {"/purchase/agendas/{agendaId}/edit"})
    public String showEditAgendaModel(Model model, @PathVariable long agendaId) {
        AgendaModel agenda = null;
        try {
            agenda = agendaService.findById(agendaId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("agenda", agenda);
        //return "agenda-edit";
        return "purchase-edit";
    }

    @PostMapping(value = {"/purchase/agendas/{agendaId}/edit"})
    public String updateAgendaModel(Model model,
                                @PathVariable long agendaId,
                                @ModelAttribute("agenda") AgendaModel agenda) {
        try {
            agenda.setId(agendaId);
            agendaService.update(agenda);
            return "redirect:/purchase/agendas/" + String.valueOf(agenda.getId());
        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            //return "agenda-edit";
            return "purchase-edit";
        }
    }

    @GetMapping(value = {"/purchase/agendas/{agendaId}/delete"})
    public String showDeleteAgendaModelById(
            Model model, @PathVariable long agendaId) {
        AgendaModel agenda = null;
        try {
            agenda = agendaService.findById(agendaId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "AgendaModel not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("agenda", agenda);
        // return "agenda";
        return "purchase";
    }

    @PostMapping(value = {"/purchase/agendas/{agendaId}/delete"})
    public String deleteAgendaModelById(
            Model model, @PathVariable long agendaId) {
        try {
            agendaService.deleteById(agendaId);
            return "redirect:/purchase/agendas";
        } catch (ResourceNotFoundException ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            // return "agenda";
            return "purchase";
        }
    }
}
