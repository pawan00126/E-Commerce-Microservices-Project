package com.pawan.Service;

import com.pawan.Entity.Product;
import com.pawan.Repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public Product createProduct(Product product) {
        return repository.save(product);
    }


    public List<Product> getAllProducts() {
        return repository.findAll();
    }


    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
