package com.shop.dao;

import com.shop.model.CarDTO;

import java.util.List;

/**
 * Created by master on 5.5.17.
 */
public interface CarDTOMapper {
    List<CarDTO> findAll();
}
