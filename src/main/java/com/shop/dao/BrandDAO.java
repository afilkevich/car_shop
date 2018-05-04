package com.shop.dao;

import com.shop.model.Brand;


import java.util.List;

/**
 * Created by master on 27.4.17.
 */
public interface BrandDAO {
    public List<Brand> findAll();
    Brand findByName(String name) ;
    //Brand findById(Integer id);
    //public void insert(Brand brand);
    //public void update(Brand brand);

}