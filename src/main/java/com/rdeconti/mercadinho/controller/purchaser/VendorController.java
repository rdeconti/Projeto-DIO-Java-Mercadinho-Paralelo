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

    private static final Logger log = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    private VendorService vendorService;

    @GetMapping(value = "/purchaser/vendor-list")
    public ModelAndView vendorListAll(Model model,
                                        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<VendorModel> vendors = vendorService.findAll(pageNumber, ROW_PER_PAGE);

        long count = vendorService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", vendors);
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
                                         @PathVariable long vendorId) {

        VendorModel vendor = null;

        try {
            vendor = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "VendorModel not found");

        }

        model.addAttribute("object", vendor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-list");
        return modelAndView;

    }

    @GetMapping(value = {"/purchaser/vendor-create"})
    public ModelAndView vendorCreateGet(Model model) {

        VendorModel vendor = new VendorModel();

        model.addAttribute("add", true);
        model.addAttribute("object", vendor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-create");
        return modelAndView;
    }

    @PostMapping(value = "/purchaser/vendor-create")
    public ModelAndView vendorCreatePost(Model model,
                                           @ModelAttribute("vendor") VendorModel vendor) {

        try {

            VendorModel newVendorModel = vendorService.save(vendor);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/vendor-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/vendor-update/{vendorId}"})
    public ModelAndView vendorUpdateGet(Model model,
                                          @PathVariable long vendorId) {

        VendorModel vendor = null;

        try {
            vendor = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "VendorModel not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", vendor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-update");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/vendor-update/{vendorId}"})
    public ModelAndView vendorUpdatePost(Model model,
                                           @PathVariable long vendorId,
                                           @ModelAttribute("vendor") VendorModel vendor) {

        try {

            vendor.setId(vendorId);
            vendorService.update(vendor);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/vendor-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
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
                                          @PathVariable long vendorId) {

        VendorModel vendor = null;

        try {
            vendor = vendorService.findById(vendorId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", vendor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/vendor-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/vendor-delete/{vendorId}"})
    public ModelAndView vendorDeletePost(Model model,
                                           @PathVariable long vendorId) {

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
