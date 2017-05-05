package com.shop.service;

import com.shop.model.ShoppingCart;
import com.shop.model.ShoppingCartDTO;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Integer id);
    Integer insert(ShoppingCart cartDTO);
    Integer update(ShoppingCart cartDTO);
    Integer delete(Integer id);
    void calculatePrice(ShoppingCart cartDTO);
}
