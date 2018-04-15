package com.shop.dao;

import com.shop.model.Model;

import java.util.List;

/**
 * Created by master on 28.4.17.
 */
public interface ModelMapper {
     List<Model> findAll();
     Model findByName(String name);
     Model findById(Integer id);
     void insert(Model model);
     void update(Model model);
}
