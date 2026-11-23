package com.wipro.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.coupon.dto.request.Coupon;
import com.wipro.coupon.dto.response.CouponResponse;
import com.wipro.coupon.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService service;

    @PostMapping
    public Coupon saveCoupon(@RequestBody Coupon coupon) {
        return service.saveCoupon(coupon);
    }

    @GetMapping("/{code}")
    public CouponResponse getCoupon(@PathVariable String code) {

        Coupon coupon = service.getCoupon(code);

        CouponResponse response = new CouponResponse();

        response.setCode(coupon.getCode());
        response.setDiscount(coupon.getDiscount());
        response.setStatus("SUCCESS");

        return response;
    }

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return service.getAllCoupons();
    }
}