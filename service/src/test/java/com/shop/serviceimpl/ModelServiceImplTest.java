package com.shop.serviceimpl;

import com.shop.model.Model;
import com.shop.service.ModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by master on 2.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
@Transactional
public class ModelServiceImplTest {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String NAME="Sedan";
    private static final Model MODEL=new Model("Jeep");
    private static final Integer ID=2;

    @Autowired
    ModelService modelService;

    @Test
    public void findAll() throws Exception {
        List<Model> list=modelService.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void findByName() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}