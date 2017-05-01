package com.shop.dao;


import com.shop.model.Model;
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
 * Created by master on 28.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class ModelMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    ModelMapper modelMapper;

    private static final String NAME="Sedan";
    private  static final String NAME_UP="Sedan1";
    private static final Model MODEL_Up=new Model("Jeep");


    @Test
    public void findAll() throws Exception {
        LOGGER.debug("ModelMapperTest:findall()");
        List<Model> list=modelMapper.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByName() throws Exception {
        LOGGER.debug("ModelMapperTest:findByName()");
        Model model =modelMapper.findByName(NAME);
        Assert.assertNotNull(model);
    }

    @Test
    public void findById() throws Exception{
        LOGGER.debug("ModelMapperTest:findById");
        Model model=modelMapper.findById(1);
        Assert.assertNotNull(model);
    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("ModelMapperTest:insert()");
        modelMapper.insert(MODEL_Up);
        Model model =modelMapper.findByName(MODEL_Up.getName());
        Assert.assertNotNull(model);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("ModelMapperTest:update()");
        Model model=modelMapper.findByName("Sedan");
        model.setName(NAME_UP);
        modelMapper.update(model);
        model=modelMapper.findByName(NAME_UP);
        Assert.assertNotNull(model);
    }


}