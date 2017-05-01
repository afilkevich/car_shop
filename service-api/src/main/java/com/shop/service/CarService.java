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
    void insert(Car car);
    void update(Car car);
    void delete(Integer id);
}
