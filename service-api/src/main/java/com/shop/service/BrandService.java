package com.shop.service;

import com.shop.model.Brand;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface BrandService {
     List<Brand> findAll();
     Brand findByName(String name);
     void insert(Brand brand);
     void update(Brand brand);
}
