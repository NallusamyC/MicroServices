package com.wipro.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.product.dto.request.Product;
import com.wipro.product.exception.ProductIdNotFoundException;
import com.wipro.product.repository.ProductRepository;

@Service
public class ProductServiceImpl
        implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductById(int id) {

        return repository.findById(id)
                .orElseThrow(() ->
                new ProductIdNotFoundException(
                        "Product Not Found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
