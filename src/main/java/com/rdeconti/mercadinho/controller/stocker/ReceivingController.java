package com.rdeconti.mercadinho.controller.stocker;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ProductModel;
import com.rdeconti.mercadinho.services.stocker.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ReceivingController {

    private static final Logger log = Logger.getLogger(ReceivingController.class.getName());

    @Autowired
    private ProductService receivingService;

    @GetMapping(value = "/receiving/receiving-list")
    public ModelAndView receivingListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<ProductModel> receivings = receivingService.findAll(pageNumber, ROW_PER_PAGE);

        long count = receivingService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", receivings);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/receiving-list");
        return modelAndView;

    }

    @GetMapping(value = "/receiving/receiving-list/{receivingId}")
    public ModelAndView receivingListById(Model model,
                                       @PathVariable long receivingId) {

        ProductModel receiving = null;

        try {
            receiving = receivingService.findById(receivingId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", receiving);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/receiving-list");
        return modelAndView;

    }

    @GetMapping(value = {"/receiving/receiving-create"})
    public ModelAndView receivingCreateGet(Model model) {

        ProductModel receiving = new ProductModel();

        model.addAttribute("add", true);
        model.addAttribute("object", receiving);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/receiving-create");
        return modelAndView;
    }

    @PostMapping(value = "/receiving/receiving-create")
    public ModelAndView receivingCreatePost(Model model,
                                         @ModelAttribute("receiving") ProductModel receiving) {

        try {

            ProductModel newProductModel = receivingService.save(receiving);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/receiving-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/receiving-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/receiving/receiving-update/{receivingId}"})
    public ModelAndView receivingUpdateGet(Model model,
                                        @PathVariable long receivingId) {

        ProductModel receiving = null;

        try {
            receiving = receivingService.findById(receivingId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", receiving);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/receiving-update");
        return modelAndView;
    }

    @PostMapping(value = {"/receiving/receiving-update/{receivingId}"})
    public ModelAndView receivingUpdatePost(Model model,
                                         @PathVariable long receivingId,
                                         @ModelAttribute("receiving") ProductModel receiving) {

        try {

            receiving.setId(receivingId);
            receivingService.update(receiving);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/receiving-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/receiving-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/receiving/receiving-delete/{receivingId}"})
    public ModelAndView receivingDeleteGet(Model model,
                                        @PathVariable long receivingId) {

        ProductModel receiving = null;

        try {
            receiving = receivingService.findById(receivingId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", receiving);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/receiving-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/receiving/receiving-delete/{receivingId}"})
    public ModelAndView receivingDeletePost(Model model,
                                         @PathVariable long receivingId) {

        try {

            receivingService.deleteById(receivingId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/receiving-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/receiving-delete");
            return modelAndView;

        }
    }
}
