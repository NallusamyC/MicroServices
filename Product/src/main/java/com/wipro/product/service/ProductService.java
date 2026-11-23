package com.wipro.product.service;
import java.util.List;
import com.wipro.product.dto.request.Product;

public interface ProductService {

Product saveProduct(Product product);

Product getProductById(int id);

List<Product> getAllProducts();

void deleteProduct(int id);
}
