package com.shop.dao;

import com.shop.model.ShoppingCartDTO;

import java.util.List;

/**
 * Created by master on 5.5.17.
 */
public interface ShoppingCartDTOMapper {
    List<ShoppingCartDTO> findAll();
    ShoppingCartDTO findById(Integer id);
}
