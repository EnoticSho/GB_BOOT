package com.example.demo.controllers;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("allProducts", productService.getProducts());
        model.addAttribute("productInfo", new Product());
        return "startPage";
    }


    @PostMapping("/products")
    public String addNewProduct(@ModelAttribute("productInfo") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String showInfo(@PathVariable int id) {
      Product product = (Product) productService.findById(id);
      return "productInfo";
    }

//    @DeleteMapping("/products/{id}")
//    public String deleteProduct(@PathVariable int id) {
//        productService.deleteById(id);
//        return "redirect:/products";
//    }
}
