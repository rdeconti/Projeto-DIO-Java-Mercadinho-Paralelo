package com.rdeconti.mercadinho.controller.stocker;

import com.rdeconti.mercadinho.controller.purchaser.PurchaseController;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ProductModel;
import com.rdeconti.mercadinho.services.stocker.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProductController {

    private static final Logger log = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/product-list")
    public ModelAndView productListAll(Model model,
                                      @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

        int ROW_PER_PAGE = 5;
        List<ProductModel> productModelList = productService.findAll(pageNumber, ROW_PER_PAGE);

        long count = productService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

        model.addAttribute("objects", productModelList);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/product-list");
        return modelAndView;

    }

    @GetMapping(value = "/product/product-list/{productId}")
    public ModelAndView productListById(Model model,
                                       @PathVariable long productId) {

        ProductModel productModel = null;

        try {
            productModel = productService.findById(productId);

        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("object", productModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/product-list");
        return modelAndView;

    }

    @GetMapping(value = {"/product/product-create"})
    public ModelAndView productCreateGet(Model model) {

        ProductModel productModel = new ProductModel();

        model.addAttribute("add", true);
        model.addAttribute("object", productModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/product-create");
        return modelAndView;
    }

    @PostMapping(value = "/product/product-create")
    public ModelAndView productCreatePost(Model model,
                                         @ModelAttribute("product") ProductModel productModel) {

        try {

            ProductModel newProductModel = productService.save(productModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/product-list");
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/product-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/product/product-update/{productId}"})
    public ModelAndView productUpdateGet(Model model,
                                        @PathVariable long productId) {

        ProductModel productModel = null;

        try {
            productModel = productService.findById(productId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");
        }

        model.addAttribute("add", false);
        model.addAttribute("object", productModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/product-update");
        return modelAndView;
    }

    @PostMapping(value = {"/product/product-update/{productId}"})
    public ModelAndView productUpdatePost(Model model,
                                         @PathVariable long productId,
                                         @ModelAttribute("product") ProductModel productModel) {

        try {

            productModel.setId(productId);
            productService.update(productModel);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/product-list") ;
            return modelAndView;

        } catch (Exception exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/product-update");
            return modelAndView;

        }
    }

    @GetMapping(value = {"/product/product-delete/{productId}"})
    public ModelAndView productDeleteGet(Model model,
                                        @PathVariable long productId) {

        ProductModel productModel = null;

        try {
            productModel = productService.findById(productId);

        } catch (ResourceNotFoundException exception) {
            model.addAttribute("errorMessage", "Registro não encontrado");

        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("object", productModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stockerRole/product-delete");
        return modelAndView;
    }

    @PostMapping(value = {"/product/product-delete/{productId}"})
    public ModelAndView productDeletePost(Model model,
                                         @PathVariable long productId) {

        try {

            productService.deleteById(productId);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/stockerRole/product-list") ;
            return modelAndView;


        } catch (ResourceNotFoundException exception) {

            String errorMessage = exception.getMessage();
            log.info(errorMessage);

            model.addAttribute("errorMessage", errorMessage);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("stockerRole/product-delete");
            return modelAndView;

        }
    }
}
