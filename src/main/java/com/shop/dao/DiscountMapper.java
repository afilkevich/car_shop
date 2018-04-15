package com.shop.dao;

import com.shop.model.Discount;

import java.util.List;

/**
 * Created by master on 28.4.17.
 */
public interface DiscountMapper {
    List<Discount> findAll();
    Discount findByValue(Integer value);
    Discount findById(Integer id);
    void insert(Discount discount);
    void update(Discount discount);
}
