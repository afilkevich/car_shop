package com.shop.dao;


import com.shop.model.Model;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by master on 28.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis-spring-test.xml"})
@Transactional
public class ModelMapperTest {
    @Autowired
    ModelMapper modelMapper;
    private static final String NAME="Sedan";

    private  static final String NAME_UP="Sedan1";
    private static final Model MODEL_Up=new Model("Jeep");


    @Test
    public void findAll() throws Exception {
        List<Model> list=modelMapper.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByName() throws Exception {
        Model model=modelMapper.findByName(NAME);
        Assert.assertNotNull(model);

    }

    @Test
    public void insert() throws Exception {
        modelMapper.insert(MODEL_Up);
        Model model=modelMapper.findByName(MODEL_Up.getName());
        Assert.assertNotNull(model);
    }

    @Test
    public void update() throws Exception {
        Model model=modelMapper.findByName("Sedan");
        model.setName(NAME_UP);
        modelMapper.update(model);
        model=modelMapper.findByName(NAME_UP);
        Assert.assertNotNull(model);

    }


}