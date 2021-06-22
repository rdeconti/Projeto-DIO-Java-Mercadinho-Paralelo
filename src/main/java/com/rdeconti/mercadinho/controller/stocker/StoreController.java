package com.rdeconti.mercadinho.controller.stocker;

import com.rdeconti.mercadinho.controller.purchaser.PurchaseController;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.StoreModel;
import com.rdeconti.mercadinho.services.stocker.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class StoreController {

    private static final Logger log = Logger.getLogger(PurchaseController.class.getName());

    @Autowired
    private StoreService storeService;

    @GetMapping(value = {"/store/index"})
    public ModelAndView storeIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-index");
        return modelAndView;

    }

    @GetMapping(value = "/store/store-list")
    public ModelAndView storeListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<StoreModel> stores = storeService.findAll(pageNumber, ROW_PER_PAGE);

        long count = storeService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("stores", stores);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-list");
        return modelAndView;

    }

    @GetMapping(value = "/store/store-list/{storeId}")
    public ModelAndView storeListById(Model model,
                                       @PathVariable long storeId) {

        StoreModel store = null;

        try {
            store = storeService.findById(storeId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("store", store);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-list");
        return modelAndView;

    }

    @GetMapping(value = {"/store/store/create"})
    public ModelAndView storeCreateGet(Model model) {

        StoreModel store = new StoreModel();

        model.addAttribute("add", true);
        model.addAttribute("store", store);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-create");
        return modelAndView;
    }

    @PostMapping(value = "/store/store/create")
    public ModelAndView storeCreatePost(Model model,
                                         @ModelAttribute("store") StoreModel store) {

        try {

            StoreModel newStoreModel = storeService.save(store);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/store-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/store-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/store/store-update/{storeId}"})
    public ModelAndView storeUpdateGet(Model model,
                                        @PathVariable long storeId) {

        StoreModel store = null;

        try {
            store = storeService.findById(storeId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("store", store);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-update");
        return modelAndView;
    }

    @PostMapping(value = {"/store/store-update/{storeId}"})
    public ModelAndView storeUpdatePost(Model model,
                                         @PathVariable long storeId,
                                         @ModelAttribute("store") StoreModel store) {

        try {

            store.setId(storeId);
            storeService.update(store);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/store-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/store-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/store/store-delete/{storeId}"})
    public ModelAndView storeDeleteGet(Model model,
                                        @PathVariable long storeId) {

        StoreModel store = null;

        try {
            store = storeService.findById(storeId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("store", store);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/store-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/store/store-delete/{storeId}"})
    public ModelAndView storeDeletePost(Model model,
                                         @PathVariable long storeId) {

        try {

            storeService.deleteById(storeId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/store-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/store-delete");
            return modelAndView;

        }
    }
}
