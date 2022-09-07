package com.cg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("index");
    }
    @GetMapping("/home")
    public ModelAndView getHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/product-details")
    public ModelAndView getProductDetailsPage() {
        return new ModelAndView("product-details");
    }

    @GetMapping("/new-product")
    public ModelAndView getNewProductPage() {
        return new ModelAndView("new-products");
    }

    @GetMapping("/cart")
    public ModelAndView getCartPage() {
        return new ModelAndView("cart");
    }

    @GetMapping("/product-fill")
    public ModelAndView getFillPage() {
        return new ModelAndView("product-fill");
    }

}
