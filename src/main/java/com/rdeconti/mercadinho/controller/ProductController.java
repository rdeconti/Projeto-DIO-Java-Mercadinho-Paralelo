// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Controller to send and receive http messages regarding object PRODUCT
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.ProductModel;
import com.rdeconti.mercadinho.services.ProductService;
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

import java.util.List;

@Api(value="Mercadinho Paralelo - Product Controller")
@Controller
@Validated
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String TEMPLATE_CREATE = "product/product-create";
    private static final String TEMPLATE_READ = "product/product-read";
    private static final String TEMPLATE_UPDATE = "product/product-update";
    private static final String TEMPLATE_DELETE = "product/product-delete";
    private static final String TEMPLATE_LIST = "product/product-list";

    private static final String ATTRIBUTE_OBJECT = "object";
    private static final String ATTRIBUTE_NAME_ERROR_MESSAGE = "errorMessage";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE = "Registro não encontrado";

    private static final int ROW_PER_PAGE = 5;

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private ProductService productService;

    // -----------------------------------------------------------------------------------------------------------------
    // List objects PRODUCT (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/get/products/list/"}, method = RequestMethod.GET)
    public ModelAndView objectsList(Model model,
                                    @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        // Create list of objects limited at rows per page
        List<ProductModel> productModelList = productService.findObjectList(pageNumber, ROW_PER_PAGE);

        // Calculate number of pages and define values to previous and next
        long count = productService.countObject();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = ((long) pageNumber * ROW_PER_PAGE) < count;

        // Set attributes to be used by Thymeleaf
        model.addAttribute("objects", productModelList);
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
    // Read object PRODUCT (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a specific record from PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/get/products/read/id/{objectId}"}, method = RequestMethod.GET)
    public ModelAndView objectRead(Model model, @PathVariable long objectId) {

        ProductModel productModel = null;

        try {

            // Obtain object by ID
            productModel = productService.findObjectById(objectId);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_OBJECT, productModel);

        } catch (ResourceNotFoundException resourceNotFoundException) {

            // Set message error
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Formatting status (due MySql has TINYINT(1))
        assert productModel != null;
        if (productModel.getStatus()) {
            model.addAttribute("currentStatus", true);
        } else {
            model.addAttribute("currentStatus", false);
        }

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_READ);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object PRODUCT (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Create a record into PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/get/products/create/"}, method = RequestMethod.GET)
    public ModelAndView objectCreateGet(Model model) {

        // Generate empty object
        ProductModel productModel = new ProductModel();

        // Formatting status (due MySql has TINYINT(1))
        assert productModel != null;
        if (productModel.getStatus()) {
            model.addAttribute("currentStatus", true);
        } else {
            model.addAttribute("currentStatus", false);
        }

        // Set attributes to be used by Thymeleaf
        model.addAttribute(ATTRIBUTE_OBJECT, productModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_CREATE);

        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object PRODUCT (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Create a record into PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/post/products/create/"}, method = RequestMethod.POST)
    public ModelAndView objectCreatePost(Model model,
                                         @ModelAttribute("object") ProductModel productModel) {

        try {

            // Create object
            ProductModel newContact = productService.createObject(productModel);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/products/list/");
            return modelAndView;

        } catch (Exception exception) {

            // Get message exception
            // String errorMessage = exception.getMessage();
            String errorMessage = "Informar os campos obrigatórios (*)";
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_CREATE);
            return modelAndView;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object PRODUCT (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Update a record into PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/get/products/update/id/{objectId}/"}, method = RequestMethod.GET)
    public ModelAndView objectUpdateGet(Model model, @PathVariable long objectId) {

        ProductModel productModel = null;

        try {

            // Obtain object by ID
            productModel = productService.findObjectById(objectId);

        } catch (ResourceNotFoundException exception) {

            // Send message error
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Formatting status (due MySql has TINYINT(1))
        assert productModel != null;
        if (productModel.getStatus()) {
            model.addAttribute("currentStatus", true);
        } else {
            model.addAttribute("currentStatus", false);
        }

        // Set attributes to be used by Thymeleaf
        model.addAttribute(ATTRIBUTE_OBJECT, productModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_UPDATE);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object PRODUCT (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Update a record into PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/post/products/update/id/{objectId}"}, method = RequestMethod.POST)
    public ModelAndView objectUpdatePost(Model model,
                                         @PathVariable long objectId,
                                         @ModelAttribute("object") ProductModel productModel) {

        try {

            // Update object
            productModel.setId(objectId);
            productService.updateObject(productModel);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/products/read/id/" + productModel.getId());
            return modelAndView;

        } catch (Exception exception) {

            // Message from validator not in use: String errorMessage = exception.getMessage();
            String errorMessage = "Informar os campos obrigatórios (*)";
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_UPDATE);
            return modelAndView;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object PRODUCT (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "GET: Delete a record from PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/get/products/delete/id/{objectId}"}, method = RequestMethod.GET)
    public ModelAndView objectDeleteGet(
            Model model, @PathVariable long objectId) {

        ProductModel productModel = null;

        try {

            // Obtain object by ID
            productModel = productService.findObjectById(objectId);

        } catch (ResourceNotFoundException exception) {

            // Send message error
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, ATTRIBUTE_VALUE_ERROR_MESSAGE);

        }

        // Formatting status (due MySql has TINYINT(1))
        assert productModel != null;
        if (productModel.getStatus()) {
            model.addAttribute("currentStatus", true);
        } else {
            model.addAttribute("currentStatus", false);
        }

        // Set attributes to be used by Thymeleaf
        model.addAttribute(ATTRIBUTE_OBJECT, productModel);

        // Create and set template to be displayed
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TEMPLATE_DELETE);
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object PRODUCT (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "POST: Delete a record from PRODUCT", response = Iterable.class)
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

    @RequestMapping(value={"/api/v1/post/products/delete/id/{objectId}"}, method = RequestMethod.POST)
    public ModelAndView objectDeletePost(
            Model model, @PathVariable long objectId) {

        try {

            // Delete object
            productService.deleteObject(objectId);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/api/v1/get/products/list/");
            return modelAndView;

        } catch (ResourceNotFoundException exception) {

            // Send message error
            String errorMessage = exception.getMessage();
            logger.error(errorMessage);

            // Set attributes to be used by Thymeleaf
            model.addAttribute(ATTRIBUTE_NAME_ERROR_MESSAGE, errorMessage);

            // Create and set template to be displayed
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(TEMPLATE_DELETE);
            return modelAndView;
        }
    }
}
