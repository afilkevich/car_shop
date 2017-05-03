package com.shop.service;

import com.shop.model.ShoppingCart;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Integer id);
    void insert(ShoppingCart cart);
    void update(ShoppingCart cart);
    void delete(Integer id);
    void calculatePrice(ShoppingCart cart);
}
