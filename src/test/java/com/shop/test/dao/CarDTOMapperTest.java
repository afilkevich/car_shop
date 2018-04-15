package com.shop.test.dao;

import com.shop.dao.CarDTOMapper;
import com.shop.model.CarDTO;
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
 * Created by master on 5.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-test.xml"})
@Transactional
public class CarDTOMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();
    private static final String BRAND="Toyota";
    private static final Integer ID=1;
    private static final String MODEL="Sedan";

    @Autowired
    CarDTOMapper carDTOMapper;

    @Test
    public void findAll() throws Exception{
        LOGGER.debug("CarDTOMapper test: findAll()");
        List<CarDTO>list=carDTOMapper.findAll();

        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByBrand() throws Exception{
        LOGGER.debug("CarDTOMapper test: findByBrand()");
        List<CarDTO>list=carDTOMapper.findByBrand(BRAND);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByModel() throws Exception{
        LOGGER.debug("CarDtoMapper test: findByModel()");
        List<CarDTO>list=carDTOMapper.findByModel(MODEL);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByBrandAndModel() throws Exception{
        LOGGER.debug("CarDtoMapper test: findByBrandAndModel()");
        List<CarDTO>list=carDTOMapper.findByBrandAndModel(BRAND,MODEL);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findById()throws Exception{
        LOGGER.debug("CarDTOMapper test: findById()");
        CarDTO carDTO=carDTOMapper.findById(ID);
        Assert.assertNotNull(carDTO);
    }
}