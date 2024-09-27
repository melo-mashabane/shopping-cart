package com.example.springmvc.springmvc.controller;

import com.example.springmvc.springmvc.Service.ProductService;
import com.example.springmvc.springmvc.model.Product;
import com.example.springmvc.springmvc.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(path = "/products/total", method = RequestMethod.GET)
    public String getReceipt(Model model){
        LOG.info("Processing request for Receipt: {}", model);

        BigDecimal basketValue = productService.addTotal(productRepository.findAll());
        List<Product> itemsInBasket = productRepository.findAll();
        String purchaseDateAndTime = productService.getPurchaseDateAndTime();
        model.addAttribute("price", basketValue);
        model.addAttribute("itemsInBasket", itemsInBasket);
        model.addAttribute("purchaseDateAndTime", purchaseDateAndTime);
        LOG.info("Processing request for Receipt: {}", model);
        return "itemisedReceipt";
    }

    @RequestMapping(path = "products", method = RequestMethod.POST)
    public String saveProduct(Product product){
        LOG.info("Saving product : {}", product);
        productRepository.save(product);
        return "redirect:/products/";
    }

    @RequestMapping(path = "/allProducts", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public void deleteProduct(@PathVariable(name = "id") String id){
        productRepository.delete(id);
    }
}
