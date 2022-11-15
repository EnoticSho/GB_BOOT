package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();


    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        Product product1 = products.stream().filter(i -> Objects.equals(id, i.getId())).findFirst().orElse(null);
        return product1;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void init() {
        products.add(new Product(1, "q", 100));
        products.add(new Product(2, "w", 200));
    }
}
