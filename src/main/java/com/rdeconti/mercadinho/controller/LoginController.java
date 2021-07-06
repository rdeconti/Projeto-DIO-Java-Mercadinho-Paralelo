package com.rdeconti.mercadinho.controller;

import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.services.manager.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

// TODO REVISAR EM TODOS OS CONTROLLERS A DOCUMENTÇÃO API

@Api(value="Mercadinho Paralelo - Login Controller")
@Controller
public class LoginController {

    /// @Autowired
    private UserService userService;

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
    // -----------------------------------------------------------------------------------------------------------------
    @ApiOperation(value = "Return a list of records from AGENDA", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    ////// @RequestMapping(value={"/api/v1/get/agendas/list/"}, method = RequestMethod.GET)

    @RequestMapping(value={"/authorization/noAccess"}, method = RequestMethod.GET)
    public ModelAndView noAccess(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-noAccess");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
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
    public ModelAndView landingPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/landingPage");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
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
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/authorization/authorization-login");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
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
    public ModelAndView registration(){

        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("user", userModel);
        modelAndView.setViewName("/authorization/authorization-registration");
        return modelAndView;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // List objects (GET)
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
    public ModelAndView createNewUser(@Valid UserModel userModel, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        UserModel userModelExists = userService.findUserByUserName(userModel.getUserName());

        if (userModelExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "Já existe um usuário com este nome de usuário. Escolha outro nome!");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/authorization/authorization-registration");

        } else {
            userService.saveUser(userModel);
            modelAndView.addObject("successMessage", "Conta cadastrada com sucesso!");
            modelAndView.addObject("user", new UserModel());
            modelAndView.setViewName("/authorization/authorization-registration");

        }
        return modelAndView;
    }
}
