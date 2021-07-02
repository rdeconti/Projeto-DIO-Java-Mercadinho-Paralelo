package com.rdeconti.mercadinho.controller.purchaser;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.purchaser.VendorModel;
import com.rdeconti.mercadinho.services.purchaser.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class VendorController {

    private static final Logger log = Logger.getLogger(VendorController.class.getName());

    @Autowired
    private VendorService vendorService;

    @GetMapping(value = "/purchaser/vendor-list")
    public ModelAndView vendorListAll(Model model,
                                        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<VendorModel> vendorModelList = vendorService.findAll(pageNumber, ROW_PER_PAGE);

        long count = vendorService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", vendorModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-list");
        return modelAndView;

    }

    @GetMapping(value = "/purchaser/vendor-list/{vendorId}")
    public ModelAndView vendorListById(Model model,
                                         @PathVariable Long vendorId) {

        VendorModel vendorModel = null;

        try {
            vendorModel = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", vendorModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-list");
        return modelAndView;

    }

    @GetMapping(value = {"/purchaser/vendor-create"})
    public ModelAndView vendorCreateGet(Model model) {

        VendorModel vendorModel = new VendorModel();

        model.addAttribute("add", true);
        model.addAttribute("object", vendorModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-create");
        return modelAndView;
    }

    @PostMapping(value = "/purchaser/vendor-create")
    public ModelAndView vendorCreatePost(Model model,
                                           @ModelAttribute("vendor") VendorModel vendorModel) {

        try {

            VendorModel newVendorModel = vendorService.save(vendorModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            ///// modelAndView.setViewName("purchaserRole/vendor-update");
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/purchaser/vendor-update/{vendorId}/edit"})
    public ModelAndView vendorUpdateGet(Model model,
                                          @PathVariable Long vendorId) {

        VendorModel vendorModel = null;

        try {
            vendorModel = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", vendorModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-update");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/vendor-update/{vendorId}/edit"})
    public ModelAndView vendorUpdatePost(Model model,
                                           @PathVariable Long vendorId,
                                           @ModelAttribute("vendor") VendorModel vendorModel) {

        try {

            vendorModel.setId(vendorId);
            vendorService.update(vendorModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list") ;
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/vendor-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/vendor-delete/{vendorId}"})
    public ModelAndView vendorDeleteGet(Model model,
                                          @PathVariable Long vendorId) {

        VendorModel vendorModel = null;

        try {
            vendorModel = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", vendorModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/vendor-delete/{vendorId}"})
    public ModelAndView vendorDeletePost(Model model,
                                           @PathVariable Long vendorId) {

        try {

            vendorService.deleteById(vendorId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/vendor-delete");
            return modelAndView;

        }
    }
}
