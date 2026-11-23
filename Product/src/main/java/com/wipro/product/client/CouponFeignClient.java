package com.wipro.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.product.dto.request.Coupon;

@FeignClient(name = "COUPON")
public interface CouponFeignClient {

    @GetMapping("/coupon/{code}")
    Coupon getCoupon(@PathVariable("code") String code);
}
