package com.shop.service;

import com.shop.model.ShoppingCart;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Integer id);
    Integer insert(ShoppingCart cart);
    Integer update(ShoppingCart cart);
    Integer delete(Integer id);
    void calculatePrice(ShoppingCart cart);
}
