package com.shop.dao;

import com.shop.model.Brand;

import java.util.List;

/**
 * Created by master on 27.4.17.
 */
public interface BrandMapper {
    public List<Brand> findAll();
   // public Brand findByName();
    //public void insert(Brand brand);
    //public void update(Brand brand);
    //public void delete( Integer id);
}