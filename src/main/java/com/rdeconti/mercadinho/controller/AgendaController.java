// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Controller to send and receive http messages regarding object AGENDA
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.services.AgendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Api(value="Mercadinho Paralelo - Agenda Controller")
@Controller
@Validated
public class AgendaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String TEMPLATE_EDIT = "agenda/agenda-edit";
    private static final String TEMPLATE_READ = "agenda/agenda-read";
    private static final String TEMPLATE_LIST = "agenda/agenda-list";

    private static final String ATTRIBUTE_OBJECT = "object";
    private static final String ATTRIBUTE_NAME_ERROR_MESSAGE = "errorMessage";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE = "Registro não encontrado";

    private static final int ROW_PER_PAGE = 5;

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AgendaService agendaService;

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/get/agendas/list/"}, method = RequestMethod.GET)
    public ModelAndView objectsList(Model model,
        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        // Create list of objects limited at rows per page
        List<AgendaModel> agendaModelList = agendaService.findObjectList(pageNumber, ROW_PER_PAGE);

        // Calculate number of pages and define values to previous and next
        long count = agendaService.countObject();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = ((long) pageNumber * ROW_PER_PAGE) < count;

        // Set attributes to be used by Thymeleaf
        model.addAttribute("objects", agendaModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_LIST);
        return modelAndView;

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Read object (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a specific record from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/get/agendas/read/id/{objectId}"}, method = RequestMethod.GET)
    public ModelAndView objectRead(Model model, @PathVariable long objectId) {

        AgendaModel agendaModel = null;

        try {

            // Obtain object by ID
            agendaModel = agendaService.findObjectById(objectId);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_OBJECT, agendaModel);

        } catch (ResourceNotFoundException resourceNotFoundException) {

            // Set message error
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_READ);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Create a record into AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/get/agendas/create/"}, method = RequestMethod.GET)
    public ModelAndView objectCreateGet(Model model) {

        // Generate empty object
        AgendaModel agendaModel = new AgendaModel();

        // Set attributes to be used by Thymeleaf
        model.addAttribute("add", true);
        model.addAttribute(ATTRIBUTE_OBJECT, agendaModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_EDIT);

        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Create a record into AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/post/agendas/create/"}, method = RequestMethod.POST)
    public ModelAndView objectCreatePost(Model model,
                                 @ModelAttribute("object") AgendaModel agendaModel) {

        try {

            // Create object
            AgendaModel newContact = agendaService.createObject(agendaModel);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/agendas/read/id/" + newContact.getId());
            return modelAndView;

        } catch (Exception exception) {

            // Get message exception
            // String errorMessage = exception.getMessage();
            String errorMessage = "Informar os campos obrigatórios (*)";
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);
            model.addAttribute("add", true);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_EDIT);
            return modelAndView;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Update a record into AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/get/agendas/update/id/{objectId}/"}, method = RequestMethod.GET)
    public ModelAndView objectUpdateGet(Model model, @PathVariable long objectId) {

        AgendaModel agendaModel = null;

        try {

            agendaModel = agendaService.findObjectById(objectId);

        } catch (ResourceNotFoundException exception) {

            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Set attributes to be used by Thymeleaf
        model.addAttribute("add", false);
        model.addAttribute(ATTRIBUTE_OBJECT, agendaModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_EDIT);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Update a record into AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/post/agendas/update/id/{objectId}"}, method = RequestMethod.POST)
    public ModelAndView objectUpdatePost(Model model,
                                      @PathVariable long objectId,
                                      @ModelAttribute("object") AgendaModel agendaModel) {

        try {

            agendaModel.setId(objectId);
            agendaService.updateObject(agendaModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/agendas/read/id/" + agendaModel.getId());
            return modelAndView;

        } catch (Exception exception) {

            // String errorMessage = exception.getMessage();
            String errorMessage = "Informar os campos obrigatórios (*)";
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);
            model.addAttribute("add", false);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_EDIT);
            return modelAndView;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Delete a record from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/get/agendas/delete/id/{objectId}"}, method = RequestMethod.GET)
    public ModelAndView objectDeleteGet(
            Model model, @PathVariable long objectId) {

        AgendaModel agendaModel = null;

        try {
            agendaModel = agendaService.findObjectById(objectId);

        } catch (ResourceNotFoundException exception) {

            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Set attributes to be used by Thymeleaf
        model.addAttribute("allowDelete", true);
        model.addAttribute(ATTRIBUTE_OBJECT, agendaModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_READ);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Delete a record from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request was successfully completed"),
            @ApiResponse(code = 201, message = "Object was successfully created"),
            @ApiResponse(code = 400, message = "The request was invalid."),
            @ApiResponse(code = 401, message = "The request did not include an authentication token or the authentication token was expired."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden."),
            @ApiResponse(code = 404, message = "The requested resource was not found."),
            @ApiResponse(code = 405, message = "The HTTP method in the request was not supported by the resource. For example, the DELETE method cannot be used with the Agent API."),
            @ApiResponse(code = 409, message = "The request could not be completed due to a conflict. For example,  POST ContentStore Folder API cannot complete if the given file or folder name already exists in the parent location."),
            @ApiResponse(code = 500, message = "The request was not completed due to an internal error on the server side."),
            @ApiResponse(code = 503, message = "The server was unavailable."),
    }
    )

    @RequestMapping(value={"/api/v1/post/agendas/delete/id/{objectId}"}, method = RequestMethod.POST)
    public ModelAndView objectDeletePost(
           Model model, @PathVariable long objectId) {

        try {

            agendaService.deleteObject(objectId);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/agendas/list/");
            return modelAndView;

        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_READ);
            return modelAndView;
        }
    }
}
