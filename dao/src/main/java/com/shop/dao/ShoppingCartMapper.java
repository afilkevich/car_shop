package com.shop.dao;

import com.shop.model.ShoppingCart;

import java.util.List;

/**
 * Created by master on 29.4.17.
 */
public interface ShoppingCartMapper {
     List<ShoppingCart> findAll();
     ShoppingCart findById(String id);
     void insert(ShoppingCart cart);
     void update(ShoppingCart cart);

}
