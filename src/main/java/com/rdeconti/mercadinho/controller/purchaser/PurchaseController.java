package com.rdeconti.mercadinho.controller.purchaser;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.purchaser.PurchaseModel;
import com.rdeconti.mercadinho.services.purchaser.PurchaseService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PurchaseController {

    private static final Logger log = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(value = {"/purchaser/index"})
    public ModelAndView purchaseIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchaser-index");
        return modelAndView;

    }

    @GetMapping(value = "/purchaser/purchase-list")
    public ModelAndView purchaseListAll(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<PurchaseModel> purchaseModelList = purchaseService.findAll(pageNumber, ROW_PER_PAGE);

        long count = purchaseService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", purchaseModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchase-list");
        return modelAndView;

    }

    @GetMapping(value = "/purchaser/purchase-list/{purchaseId}")
    public ModelAndView purchaseListById(Model model,
                                 @PathVariable long purchaseId) {

        PurchaseModel purchaseModel = null;

        try {
            purchaseModel = purchaseService.findById(purchaseId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", purchaseModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchase-list");
        return modelAndView;

    }

    @GetMapping(value = {"/purchaser/purchase-create"})
    public ModelAndView purchaseCreateGet(Model model) {

        PurchaseModel purchaseModel = new PurchaseModel();

        model.addAttribute("add", true);
        model.addAttribute("object", purchaseModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchase-create");
        return modelAndView;
    }

    @PostMapping(value = "/purchaser/purchase-create")
    public ModelAndView purchaseCreatePost(Model model,
                                   @ModelAttribute("purchase") PurchaseModel purchaseModel) {

        try {

            PurchaseModel newPurchaseModel = purchaseService.save(purchaseModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/purchase-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/purchase-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/purchase-update/{purchaseId}"})
    public ModelAndView purchaseUpdateGet(Model model,
                                        @PathVariable long purchaseId) {

        PurchaseModel purchaseModel = null;

        try {
            purchaseModel = purchaseService.findById(purchaseId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", purchaseModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchase-update");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/purchase-update/{purchaseId}"})
    public ModelAndView purchaseUpdatePost(Model model,
                                        @PathVariable long purchaseId,
                                        @ModelAttribute("purchase") PurchaseModel purchaseModel) {

        try {

            purchaseModel.setId(purchaseId);
            purchaseService.update(purchaseModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/purchase-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/purchase-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/purchaser/purchase-delete/{purchaseId}"})
    public ModelAndView purchaseDeleteGet(Model model,
                                        @PathVariable long purchaseId) {

        PurchaseModel purchaseModel = null;

        try {
            purchaseModel = purchaseService.findById(purchaseId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", purchaseModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaserRole/purchase-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/purchaser/purchase-delete/{purchaseId}"})
    public ModelAndView purchaseDeletePost(Model model,
                                    @PathVariable long purchaseId) {

        try {

            purchaseService.deleteById(purchaseId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/purchaserRole/purchase-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("purchaserRole/purchase-delete");
            return modelAndView;

        }
    }
}
