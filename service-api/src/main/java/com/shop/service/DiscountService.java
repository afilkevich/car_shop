package com.shop.service;

import com.shop.model.Discount;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface DiscountService {
    List<Discount> findAll();
    Discount findByValue(Integer value);
    Discount findById(Integer id);
    void insert(Discount discount);
    void update(Discount discount);
}
