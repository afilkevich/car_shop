package com.shop.service;

import com.shop.model.Car;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface CarService {
    List<Car> findAll();
    List<Car> findByIdBrand(Integer idBrand);
    List<Car> findByIdModel(Integer idModel);
    Car findById(Integer id);
    Integer insert(Car car);
    Integer update(Car car);
    Integer delete(Integer id);
}
