package com.wipro.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.product.dto.request.Product;

public interface ProductRepository
       extends JpaRepository<Product,Integer> {

}