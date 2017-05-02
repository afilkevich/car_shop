package com.shop.serviceimpl;

import com.shop.model.Config;
import com.shop.service.ConfigService;
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

import static org.junit.Assert.*;

/**
 * Created by master on 2.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
@Transactional
public class ConfigServiceImplTest {

    private static final Logger LOGGER= LogManager.getLogger();

    private static final Integer ID=2;
    private static final Integer WRONG_ID=8;
    private static final String TYPE="Standart";
    private static final String WRONG_TYPE="Normal";
    private static final Config CONFIG=new Config("Apgrate","All inclusive");
    private static final Config UP_CONFIG=new Config(1,"Minimals","vent");


    @Autowired
    ConfigService configService;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("ConfigServiceImpl test: findAll");
        List<Config> list=configService.findAll();
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("ConfigServiceImpl test: findById");
        Config config=configService.findById(ID);
        Assert.assertEquals(ID,config.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullId() throws Exception{
        LOGGER.debug("ConfigServiceImpl test: findByNullId");
        Config config=configService.findById(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findByWrongId() throws Exception{
        LOGGER.debug("ConfigServiceImpl test:findByWrongId");
        Config config=configService.findById(WRONG_ID);
    }

    @Test
    public void findByType() throws Exception {
   LOGGER.debug("ConfigServiceImpl test: findByType");
        Config config=configService.findByType(TYPE);
        Assert.assertNotNull(config);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}