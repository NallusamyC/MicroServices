package com.wipro.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.coupon.dto.request.Coupon;
import com.wipro.coupon.exception.CouponNotFoundException;
import com.wipro.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl
        implements CouponService {

    @Autowired
    CouponRepository repository;

    @Override
    public Coupon saveCoupon(
            Coupon coupon) {

        return repository.save(coupon);
    }

    @Override
    public Coupon getCoupon(
            String code) {

        return repository.findById(code)
                .orElseThrow(() ->
                 new CouponNotFoundException(
                 "Coupon Not Found"));
    }

    @Override
    public List<Coupon> getAllCoupons() {

        return repository.findAll();
    }
}
