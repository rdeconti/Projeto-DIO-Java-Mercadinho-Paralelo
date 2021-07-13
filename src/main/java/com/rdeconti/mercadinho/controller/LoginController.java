package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

// TODO REVISAR EM TODOS OS CONTROLLERS A DOCUMENTÇÃO API

@Api(value="Mercadinho Paralelo - Login Controller")
@Controller
@Validated
public class LoginController {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private UserService userService;

    // -----------------------------------------------------------------------------------------------------------------
    // Treat Authorization NoAccess (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @RequestMapping(value={"/authorization/noAccess"}, method = RequestMethod.GET)
    public ModelAndView noAccessGet(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-noAccess");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Treat Authorization Landing Page - Index (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView landingPageGet(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Treat Authorization Login Page (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value={"/authorization/login"}, method = RequestMethod.GET)
    public ModelAndView loginPageGet(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-login");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Treat Authorization Registration Page (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value="/authorization/registration", method = RequestMethod.GET)
    public ModelAndView registrationPageGet(){

        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("user", userModel);
        modelAndView.setViewName("authorization/authorization-registration");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Treat Authorization Registration Page (POST)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/authorization/registration", method = RequestMethod.POST)
    public ModelAndView registrationPageGetPost(@Valid UserModel userModel, BindingResult bindingResult) throws BadResourceException, ResourceAlreadyExistsException {

        ModelAndView modelAndView = new ModelAndView();

        // Check if USER CODE already exists
        UserModel userModelExists = userService.findUserByUserName(userModel.getUserName());

        if (userModelExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "Já existe um usuário com este nome de usuário. Escolha outro nome!");
            return modelAndView;
        }

        // Check if form has errors from user
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authorization/authorization-registration");
            return modelAndView;
        }

        // Create user
        userService.createObject(userModel);

        // Set message
        modelAndView.addObject("successMessage", "Conta cadastrada com sucesso!");
        modelAndView.addObject("user", new UserModel());
        modelAndView.setViewName("authorization/authorization-registration");

        return modelAndView;
    }
}
