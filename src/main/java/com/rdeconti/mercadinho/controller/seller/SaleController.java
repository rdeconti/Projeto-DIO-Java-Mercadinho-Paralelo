package com.rdeconti.mercadinho.controller.seller;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.SaleModel;
import com.rdeconti.mercadinho.services.seller.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class SaleController {

    private static final Logger log = Logger.getLogger(SaleController.class.getName());

    @Autowired
    private SaleService saleService;

    @GetMapping(value = {"/seller/index"})
    public ModelAndView saleIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-index");
        return modelAndView;

    }

    @GetMapping(value = "/seller/sale-list")
    public ModelAndView saleListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<SaleModel> saleModelList = saleService.findAll(pageNumber, ROW_PER_PAGE);

        long count = saleService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", saleModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-list");
        return modelAndView;

    }

    @GetMapping(value = "/seller/sale-list/{saleId}")
    public ModelAndView saleListById(Model model,
                                       @PathVariable Long saleId) {

        SaleModel saleModel = null;

        try {
            saleModel = saleService.findById(saleId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", saleModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-list");
        return modelAndView;

    }

    @GetMapping(value = {"/seller/sale-create"})
    public ModelAndView saleCreateGet(Model model) {

        SaleModel saleModel = new SaleModel();

        model.addAttribute("add", true);
        model.addAttribute("object", saleModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-create");
        return modelAndView;
    }

    @PostMapping(value = "/seller/sale-create")
    public ModelAndView saleCreatePost(Model model,
                                         @ModelAttribute("sale") SaleModel sale) {

        try {

            SaleModel newSaleModel = saleService.save(sale);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/sale-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/sale-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/seller/sale-update/{saleId}"})
    public ModelAndView saleUpdateGet(Model model,
                                        @PathVariable Long saleId) {

        SaleModel saleModel = null;

        try {
            saleModel = saleService.findById(saleId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", saleModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-update");
        return modelAndView;
    }

    @PostMapping(value = {"/seller/sale-update/{saleId}"})
    public ModelAndView saleUpdatePost(Model model,
                                         @PathVariable Long saleId,
                                         @ModelAttribute("sale") SaleModel saleModel) {

        try {

            saleModel.setId(saleId);
            saleService.update(saleModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/sale-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/sale-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/seller/sale-delete/{saleId}"})
    public ModelAndView saleDeleteGet(Model model,
                                        @PathVariable Long saleId) {

        SaleModel saleModel = null;

        try {
            saleModel = saleService.findById(saleId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", saleModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerRole/sale-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/seller/sale-delete/{saleId}"})
    public ModelAndView saleDeletePost(Model model,
                                         @PathVariable Long saleId) {

        try {

            saleService.deleteById(saleId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/sellerRole/sale-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sellerRole/sale-delete");
            return modelAndView;

        }
    }
}
