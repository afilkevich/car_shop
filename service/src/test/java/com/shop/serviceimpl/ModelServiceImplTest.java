package com.shop.serviceimpl;

import com.shop.model.Model;
import com.shop.service.ModelService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    private static final String WRONG_NAME="SEd";
    private static final Model MODEL=new Model("Jeep");
    private static final Model MODEL_UP=new Model(1,"Sedan3");
    private static final Model WRONG_MODEL=new Model(4,"Jepp");
    private static final Integer ID=2;
    private static final Integer WRONG_ID=78;

    @Autowired
    ModelService modelService;
    @Test
    public void findAll() throws Exception {
        LOGGER.debug("ModelServiceImpl test: findAll");
        List<Model> list=modelService.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("ModelServiceImpl test: findById");
        Model model=modelService.findById(ID);
        Assert.assertNotNull(model);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findByNullId() throws Exception{
        LOGGER.debug("ModelServiceImpl test: findByNullId");
        Model model=modelService.findById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongId() throws Exception{
        LOGGER.debug("ModelServiceImpl test: findByWrongId");
        Model model=modelService.findById(WRONG_ID);
    }

    @Test
    public void findByName() throws Exception {
        LOGGER.debug("ModelServiceImpl test: findByName");
        Model model=modelService.findByName(NAME);
        Assert.assertNotNull(model);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void findByNullName() throws Exception{
        LOGGER.debug("ModelServiceImpl test: findByNullName");
        Model model=modelService.findByName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongName() throws Exception{
        LOGGER.debug("ModelServiceImpl test: findByWrongName");
        Model model=modelService.findByName(WRONG_NAME);
    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("ModelServiceImpl test: insert");
        modelService.insert(MODEL);
        Model model=modelService.findByName(MODEL.getName());
        Assert.assertNotNull(model);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull() throws Exception{
        LOGGER.debug("ModelServiceIpml test: insertNull");
        modelService.insert(null);
     }

     @Test(expected = IllegalArgumentException.class)
     public void insertWrongModel() throws Exception{
         LOGGER.debug("ModelServiceImpl test: insertWrongModel");
         modelService.insert(WRONG_MODEL);
     }

    @Test
    public void update() throws Exception {
        LOGGER.debug("ModelServiceImpl test: update");
        modelService.update(MODEL_UP);
        Assert.assertNotNull(modelService.findByName(MODEL_UP.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongModel() throws Exception{
        LOGGER.debug("ModelServiceImpl test:updateWrongMoodel");
        modelService.update(WRONG_MODEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNullModel() throws Exception{
        LOGGER.debug("ModelServiceImpl test: updateNullModel");
        modelService.update(null);

    }

}