package com.wipro.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.product.client.CouponFeignClient;
import com.wipro.product.dto.request.Coupon;
import com.wipro.product.dto.request.Product;
import com.wipro.product.dto.response.ProductResponse;
import com.wipro.product.service.ProductService;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    CouponFeignClient couponClient;

    @PostMapping
    public Product saveProduct(
            @RequestBody Product product) {

        return service.saveProduct(product);
    }

   // @CircuitBreaker(
      //      name = "Product",
         //   fallbackMethod = "handleError")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse>
                getProductById(
                @PathVariable int id) {

        Product product =
                service.getProductById(id);

        ProductResponse response =
                new ProductResponse();

        response.setPname(product.getPname());

        Coupon coupon =
                couponClient.getCoupon(
                        product.getCouponCode());

        int finalPrice =
                product.getPprice()
                  - coupon.getDiscount();

        response.setPprice(finalPrice);
        response.setStatus("SUCCESS");

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ProductResponse>
          handleError(int id, Exception ex) 
    {
        ProductResponse response =
                new ProductResponse();

        response.setStatus(
                "Coupon Service Down");

        response.setPname("NA");
        response.setPprice(0);

        return ResponseEntity.ok(response);
    }
}
