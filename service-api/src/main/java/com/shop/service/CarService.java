package com.shop.service;

import com.shop.model.Car;
import com.shop.model.CarDTO;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface CarService {
    List<CarDTO> findAll();
    List<CarDTO> findByBrand(String brand);
    List<CarDTO> findByModel(String model);
    List<CarDTO> findByBrandAndModel(String brand, String model);
    CarDTO findById(Integer id);
    Integer insert(CarDTO car);
    Integer update(CarDTO car);
    Integer delete(Integer id);
}
