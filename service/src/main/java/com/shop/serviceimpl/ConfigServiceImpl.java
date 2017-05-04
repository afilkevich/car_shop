package com.shop.serviceimpl;

import com.shop.dao.ConfigMapper;
import com.shop.model.Config;
import com.shop.service.ConfigService;
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
public class ConfigServiceImpl implements ConfigService {
  private static final Logger LOGGER= LogManager.getLogger();

     @Autowired
    ConfigMapper configMapper;

    public void setConfigMapper(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    @Override
    public List<Config> findAll() {
        LOGGER.debug("ConfigServiceImpl: findAll");
        return configMapper.findAll();
    }

    @Override
    public Config findById(Integer id) {
        LOGGER.debug("ConfigServiceImpl: findById",id);
        Assert.notNull(id);
        Assert.isTrue(id!=0);
        Config config=configMapper.findById(id);
        Assert.notNull(config);
        return config;
    }

    @Override
    public Config findByType(String type) {
        LOGGER.debug("ConfigServiceImpl: findByType", type);
        Assert.notNull(type);
        Assert.hasText(type);
        Config config=configMapper.findByType(type);
        Assert.notNull(config);
        return config;
    }

    @Override
    public Integer insert(Config config) {
        LOGGER.debug("ConfigServiceImpl: insert", config);
        Assert.notNull(config);
        Assert.isNull(config.getId());
        Assert.hasText(config.getType());
        Assert.hasText(config.getDescription());
        configMapper.insert(config);
        return configMapper.findByType(config.getType()).getId();
    }

    @Override
    public Integer update(Config config) {
        LOGGER.debug("ConfigServiceImpl:update", config);
        Assert.notNull(config);
        Assert.notNull(config.getId());
        Assert.notNull(configMapper.findById(config.getId()));
        Assert.hasText(config.getType());
        Assert.hasText(config.getDescription());
        configMapper.update(config);
        return config.getId();

    }
}
