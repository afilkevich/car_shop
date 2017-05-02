package com.shop.serviceimpl;

import com.shop.dao.ModelMapper;
import com.shop.model.Model;
import com.shop.service.ModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by master on 2.5.17.
 */
public class ModelServiceImpl implements ModelService {

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    ModelMapper modelMapper;

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Model> findAll() {
        LOGGER.debug("ModelServiceImpl: findAll");
        return modelMapper.findAll();
    }

    @Override
    public Model findById(Integer id) {
        return null;
    }

    @Override
    public Model findByName(String name) {
        return null;
    }

    @Override
    public void insert(Model model) {

    }

    @Override
    public void update(Model model) {

    }
}
