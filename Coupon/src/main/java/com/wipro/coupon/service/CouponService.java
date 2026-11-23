package com.wipro.coupon.service;

import java.util.List;

import com.wipro.coupon.dto.request.Coupon;

public interface CouponService {

    Coupon saveCoupon(Coupon coupon);

    Coupon getCoupon(String code);

    List<Coupon> getAllCoupons();
}
