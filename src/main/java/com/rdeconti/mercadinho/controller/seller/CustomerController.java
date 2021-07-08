package com.rdeconti.mercadinho.controller.seller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.CustomerModel;
import com.rdeconti.mercadinho.services.seller.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Api(value="Mercadinho Paralelo - Customer Controller")
@Controller
@Validated
public class CustomerController {

    private static final Logger log = Logger.getLogger(CustomerController.class.getName());

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer/customer-list")
    public ModelAndView customerListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<CustomerModel> customerModelList = customerService.findAll(pageNumber, ROW_PER_PAGE);

        long count = customerService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", customerModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/customer-list");
        return modelAndView;

    }

    @GetMapping(value = "/customer/customer-list/{customerId}")
    public ModelAndView customerListById(Model model,
                                       @PathVariable Long customerId) {

        CustomerModel customerModel = null;

        try {
            customerModel = customerService.findById(customerId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", customerModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/customer-list");
        return modelAndView;

    }

    @GetMapping(value = {"/customer/customer-create"})
    public ModelAndView customerCreateGet(Model model) {

        CustomerModel customerModel = new CustomerModel();

        model.addAttribute("add", true);
        model.addAttribute("object", customerModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/customer-create");
        return modelAndView;
    }

    @PostMapping(value = "/customer/customer-create")
    public ModelAndView customerCreatePost(Model model,
                                         @ModelAttribute("customer") CustomerModel customer) {

        try {

            CustomerModel newCustomerModel = customerService.save(customer);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/customer-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/customer-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/customer/customer-update/{customerId}"})
    public ModelAndView customerUpdateGet(Model model,
                                        @PathVariable Long customerId) {

        CustomerModel customerModel = null;

        try {
            customerModel = customerService.findById(customerId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", customerModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/customer-update");
        return modelAndView;
    }

    @PostMapping(value = {"/customer/customer-update/{customerId}"})
    public ModelAndView customerUpdatePost(Model model,
                                         @PathVariable Long customerId,
                                         @ModelAttribute("customer") CustomerModel customer) {

        try {

            customer.setId(customerId);
            customerService.update(customer);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/customer-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/customer-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/customer/customer-delete/{customerId}"})
    public ModelAndView customerDeleteGet(Model model,
                                        @PathVariable Long customerId) {

        CustomerModel customer = null;

        try {
            customer = customerService.findById(customerId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", customer);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/customer-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/customer/customer-delete/{customerId}"})
    public ModelAndView customerDeletePost(Model model,
                                         @PathVariable Long customerId) {

        try {

            customerService.deleteById(customerId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/customer-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/customer-delete");
            return modelAndView;

        }
    }
}
