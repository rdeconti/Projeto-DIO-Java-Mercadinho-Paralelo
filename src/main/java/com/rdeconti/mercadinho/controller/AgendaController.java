package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.services.AgendaService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Contacts.",
        tags = {"agenda"})

@Controller
public class AgendaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final int ROW_PER_PAGE = 5;

    @Autowired
    private AgendaService agendaService;

    @Value("${msg.title}")
    private String title;

    @GetMapping(value = {"/agenda", "/index"})
    public String index(Model model) {
        model.addAttribute("title", title);
        return "index";
    }

    @ApiOperation(value = "Find Contacts by name", notes = "Name search by %name% format", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response=List.class )  })

    @GetMapping(value = "/agenda")
    public String getContacts(Model model, @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        List<AgendaModel> agendaModels = agendaService.findAll(pageNumber, ROW_PER_PAGE);

        long count = agendaService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("contacts", agendaModels);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "contact-list";
    }

    @ApiOperation(value = "Find contact by ID", notes = "Returns a single contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response= AgendaModel.class),
            @ApiResponse(code = 404, message = "Contact not found") })

    @GetMapping(value = "/agenda/{agendaId}")
    public String getContactById(Model model, @PathVariable long contactId) {
        AgendaModel agendaModel = null;
        try {
            agendaModel = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("contact", agendaModel);
        return "contact";
    }

    @GetMapping(value = {"/agenda/add"})
    public String showAddContact(Model model) {
        AgendaModel agendaModel = new AgendaModel();
        model.addAttribute("add", true);
        model.addAttribute("contact", agendaModel);

        return "contact-edit";
    }

    @ApiOperation(value = "Add a new contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Contact created"),
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 409, message = "Contact already exists") })

    @PostMapping(value = "/agenda/add")
    public String addContact(Model model,
                             @ApiParam("Contact to add. Cannot null or empty.")
                             @ModelAttribute("contact") AgendaModel agendaModel) {
        try {
            AgendaModel newAgendaModel = agendaService.save(agendaModel);
            return "redirect:/agenda/" + String.valueOf(newAgendaModel.getId());
        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            //model.addAttribute("contact", contact);
            model.addAttribute("add", true);
            return "contact-edit";
        }
    }

    @ApiOperation(value = "Update an existing contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Contact not found"),
            @ApiResponse(code = 405, message = "Validation exception") })

    @GetMapping(value = {"/agenda/{agendaId}/edit"})
    public String showEditContact(Model model,
                                  @ApiParam("Id of the contact to be update. Cannot be empty.")
                                  @PathVariable long contactId) {
        AgendaModel agendaModel = null;
        try {
            agendaModel = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("contact", agendaModel);
        return "contact-edit";
    }

    @ApiOperation(value = "Update an existing contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Contact not found"),
            @ApiResponse(code = 405, message = "Validation exception") })

    @PostMapping(value = {"/agenda/{agendaId}/edit"})
    public String updateContact(Model model,
                                @ApiParam("Id of the contact to be update. Cannot be empty.")
                                @PathVariable long contactId,
                                @ApiParam("Contact to update. Cannot null or empty.")
                                @ModelAttribute("contact") AgendaModel agendaModel) {
        try {
            agendaModel.setId(contactId);
            agendaService.update(agendaModel);
            return "redirect:/agenda/" + String.valueOf(agendaModel.getId());
        } catch (Exception ex) {
            // log exception first,
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            return "contact-edit";
        }
    }

    @ApiOperation(value = "Deletes a contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "Contact not found") })

    @GetMapping(value = {"/agenda/{agendaId}/delete"})
    public String showDeleteContactById(
            @ApiParam("Id of the contact to be delete. Cannot be empty.")
            Model model, @PathVariable long contactId) {
        AgendaModel agendaModel = null;
        try {
            agendaModel = agendaService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("contact", agendaModel);
        return "contact";
    }

    @ApiOperation(value = "Deletes a contact", tags = { "agenda" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "Contact not found") })

    @PostMapping(value = {"/agenda/{agendaId}/delete"})
    public String deleteContactById(
            @ApiParam("Id of the contact to be delete. Cannot be empty.")
            Model model, @PathVariable long contactId) {
        try {
            agendaService.deleteById(contactId);
            return "redirect:/agenda";
        } catch (ResourceNotFoundException ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "contact";
        }
    }
}
