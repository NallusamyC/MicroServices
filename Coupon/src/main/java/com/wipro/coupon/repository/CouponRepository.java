package com.wipro.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.coupon.dto.request.Coupon;

public interface CouponRepository
    extends JpaRepository<Coupon,String> {

}

