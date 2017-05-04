package com.shop.service;

import com.shop.model.Model;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ModelService {
    List<Model> findAll();
    Model findById(Integer id);
    Model findByName(String name);
    Integer insert(Model model);
    Integer update(Model model);
}
