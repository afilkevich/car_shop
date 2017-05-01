package com.shop.dao;

import com.shop.model.CarDTO;

import java.util.List;

/**
 * Created by master on 29.4.17.
 */
public interface CarDTOMapper {
    List<CarDTO> findAll();
}
