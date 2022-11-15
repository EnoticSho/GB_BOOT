package com.example.demo.controllers;
import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("allProducts", repository.getProducts());
        model.addAttribute("productInfo", new Product());
        return "startPage";
    }


    @PostMapping("/products")
    public String addNewProduct(@ModelAttribute("productInfo") Product product) {
        repository.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String showInfo(@PathVariable int id) {
        Product product = repository.getProduct(id);
        return product.toString();
    }

    @PostMapping("/products/pro")
    @ResponseBody
    public void addNewProduct1(@RequestBody Product product) {
        System.out.println(product.toString());
    }
}
