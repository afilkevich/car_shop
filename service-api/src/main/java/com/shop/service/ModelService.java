package com.shop.service;

import com.shop.model.Model;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
public interface ModelService {
    List<Model> findAll();
    Model findByName(String name);
    void insert(Model model);
    void update(Model model);
}
