package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public void saveProduct(Product product);

    public void deleteById(int id);

    public Object findById(int id);
}
