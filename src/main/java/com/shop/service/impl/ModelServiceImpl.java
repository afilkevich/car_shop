package com.shop.service.impl;

import com.shop.dao.ModelMapper;
import com.shop.model.Model;
import com.shop.service.ModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by master on 2.5.17.
 */
@Service
@Transactional
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
        LOGGER.debug("ModelServiceImpl: findById",id);
        Assert.notNull(id);
        Assert.isTrue(id!=0);
        Model model=modelMapper.findById(id);
        Assert.notNull(model);
        return model;
    }

    @Override
    public Model findByName(String name) {
        LOGGER.debug("ModelServiceImpl: findByName", name);
        Assert.notNull(name);
        Assert.hasText(name);
        Model model=modelMapper.findByName(name);
        Assert.notNull(model);
        return model;
    }

    @Override
    public Integer insert(Model model) {
        LOGGER.debug("ModelServiceImpl: insert",model);
        Assert.notNull(model);
        Assert.hasText(model.getName());
        Assert.isNull(model.getId());
        modelMapper.insert(model);
        return modelMapper.findByName(model.getName()).getId();
        }

    @Override
    public Integer update(Model model) {
        LOGGER.debug("ModelServiceImpl : update", model);
        Assert.notNull(model);
        Assert.notNull(modelMapper.findById(model.getId()));
        Assert.hasText(model.getName());
        modelMapper.update(model);
        return model.getId();

    }
}
