package com.rdeconti.mercadinho.controller.stocker;

import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.StockModel;
import com.rdeconti.mercadinho.services.stocker.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class StockController {

    private static final Logger log = Logger.getLogger(StockController.class.getName());

    @Autowired
    private StockService stockService;

    @GetMapping(value = {"/stock/index"})
    public ModelAndView stockIndex(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-index");
        return modelAndView;

    }

    @GetMapping(value = "/stock/stock-list")
    public ModelAndView stockListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<StockModel> stocks = stockService.findAll(pageNumber, ROW_PER_PAGE);

        long count = stockService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", stocks);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-list");
        return modelAndView;

    }

    @GetMapping(value = "/stock/stock-list/{stockId}")
    public ModelAndView stockListById(Model model,
                                       @PathVariable Long stockId) {

        StockModel stock = null;

        try {
            stock = stockService.findById(stockId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", stock);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-list");
        return modelAndView;

    }

    @GetMapping(value = {"/stock/stock-create"})
    public ModelAndView stockCreateGet(Model model) {

        StockModel stock = new StockModel();

        model.addAttribute("add", true);
        model.addAttribute("object", stock);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-create");
        return modelAndView;
    }

    @PostMapping(value = "/stock/stock-create")
    public ModelAndView stockCreatePost(Model model,
                                         @ModelAttribute("stock") StockModel stock) {

        try {

            StockModel newStockModel = stockService.save(stock);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/stock-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/stock-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/stock/stock-update/{stockId}"})
    public ModelAndView stockUpdateGet(Model model,
                                        @PathVariable Long stockId) {

        StockModel stock = null;

        try {
            stock = stockService.findById(stockId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro bão encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", stock);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-update");
        return modelAndView;
    }

    @PostMapping(value = {"/stock/stock-update/{stockId}"})
    public ModelAndView stockUpdatePost(Model model,
                                         @PathVariable Long stockId,
                                         @ModelAttribute("stock") StockModel stock) {

        try {

            stock.setId(stockId);
            stockService.update(stock);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/stock-list") ;
            return modelAndView;

        } catch (Exception ex) {

            String errorMessage = ex.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/stock-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/stock/stock-delete/{stockId}"})
    public ModelAndView stockDeleteGet(Model model,
                                        @PathVariable Long stockId) {

        StockModel stock = null;

        try {
            stock = stockService.findById(stockId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", stock);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/stock-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/stock/stock-delete/{stockId}"})
    public ModelAndView stockDeletePost(Model model,
                                         @PathVariable Long stockId) {

        try {

            stockService.deleteById(stockId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/stock-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/stock-delete");
            return modelAndView;

        }
    }
}
