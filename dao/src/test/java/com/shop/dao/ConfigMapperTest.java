package com.shop.dao;

import com.shop.model.Config;
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
public class ConfigMapperTest {

    @Autowired
    ConfigMapper configMapper;

    private static  final String TYPE ="Lux";

    private static final String TYPE_UP="lux1";
    private static final Config CONFIG=new Config("newConf"," new_desc");


    @Test
    public void findAll() throws Exception {
        List<Config> list=configMapper.findAll();
        Assert.assertTrue(list.size()>0);
       }

    @Test
    public void findByType() throws Exception {

        Config config=configMapper.findByType(TYPE);
        Assert.assertNotNull(config);

    }

    @Test
    public void insert() throws Exception {
        configMapper.insert(CONFIG);
        Config config=configMapper.findByType(CONFIG.getType());
        Assert.assertNotNull(config);

    }

    @Test
    public void update() throws Exception {
        Config config=configMapper.findByType(TYPE);
        config.setType(TYPE_UP);
        configMapper.update(config);
        config=configMapper.findByType(TYPE_UP);
        Assert.assertEquals(TYPE_UP,config.getType());

    }

}