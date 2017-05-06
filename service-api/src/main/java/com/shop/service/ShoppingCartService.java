package com.shop.service;

import com.shop.model.ShoppingCart;
import com.shop.model.ShoppingCartDTO;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ShoppingCartService {
    List<ShoppingCartDTO> findAll();
    ShoppingCartDTO findById(Integer id);
    Integer insert(ShoppingCartDTO cartDTO);
    Integer update(ShoppingCartDTO cartDTO);
    Integer delete(Integer id);
    void calculatePrice(ShoppingCart cart);
    ShoppingCart convertToAddShoppingCart(ShoppingCartDTO cartDTO);
    ShoppingCart convertToUpShoppingCart(ShoppingCartDTO cartDTO);
}
