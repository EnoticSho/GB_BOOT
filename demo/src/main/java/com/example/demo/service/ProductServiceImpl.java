package com.example.demo.service;

import com.example.demo.dao.DAOproducts;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    DAOproducts daOproducts;


    public List<Product> getProducts() {
        List <Product> products = daOproducts.findAll();
        return products;
    }

    public void saveProduct(Product product) {
        daOproducts.save(product);
    }

    @Override
    public void deleteById(int id) {
        daOproducts.deleteById(id);
    }

    @Override
    public Object findById(int id) {
        return daOproducts.findById(id);
    }

}
