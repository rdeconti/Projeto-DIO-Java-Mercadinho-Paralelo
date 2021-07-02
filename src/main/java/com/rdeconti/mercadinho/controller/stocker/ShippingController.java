package com.rdeconti.mercadinho.controller.stocker;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ShippingModel;
import com.rdeconti.mercadinho.services.stocker.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ShippingController {

    private static final Logger log = Logger.getLogger(ShippingController.class.getName());

    @Autowired
    private ShippingService shippingService;

    @GetMapping(value = "/shipping/shipping-list")
    public ModelAndView shippingListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<ShippingModel> shippingModelList = shippingService.findAll(pageNumber, ROW_PER_PAGE);

        long count = shippingService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", shippingModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/shipping-list");
        return modelAndView;

    }

    @GetMapping(value = "/shipping/shipping-list/{shippingId}")
    public ModelAndView shippingListById(Model model,
                                       @PathVariable Long shippingId) {

        ShippingModel shippingModel = null;

        try {
            shippingModel = shippingService.findById(shippingId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", shippingModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/shipping-list");
        return modelAndView;

    }

    @GetMapping(value = {"/shipping/shipping-create"})
    public ModelAndView shippingCreateGet(Model model) {

        ShippingModel shippingModel = new ShippingModel();

        model.addAttribute("add", true);
        model.addAttribute("object", shippingModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/shipping-create");
        return modelAndView;
    }

    @PostMapping(value = "/shipping/shipping-create")
    public ModelAndView shippingCreatePost(Model model,
                                         @ModelAttribute("shipping") ShippingModel shipping) {

        try {

            ShippingModel newShippingModel = shippingService.save(shipping);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/shipping-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/shipping-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/shipping/shipping-update/{shippingId}"})
    public ModelAndView shippingUpdateGet(Model model,
                                        @PathVariable Long shippingId) {

        ShippingModel shippingModel = null;

        try {
            shippingModel = shippingService.findById(shippingId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", shippingModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/shipping-update");
        return modelAndView;
    }

    @PostMapping(value = {"/shipping/shipping-update/{shippingId}"})
    public ModelAndView shippingUpdatePost(Model model,
                                         @PathVariable Long shippingId,
                                         @ModelAttribute("shipping") ShippingModel shippingModel) {

        try {

            shippingModel.setId(shippingId);
            shippingService.update(shippingModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/shipping-list") ;
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/shipping-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/shipping/shipping-delete/{shippingId}"})
    public ModelAndView shippingDeleteGet(Model model,
                                        @PathVariable Long shippingId) {

        ShippingModel shipping = null;

        try {
            shipping = shippingService.findById(shippingId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", shipping);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/shipping-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/shipping/shipping-delete/{shippingId}"})
    public ModelAndView shippingDeletePost(Model model,
                                         @PathVariable Long shippingId) {

        try {

            shippingService.deleteById(shippingId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/shipping-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/shipping-delete");
            return modelAndView;

        }
    }
}
