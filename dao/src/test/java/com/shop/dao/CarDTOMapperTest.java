package com.shop.dao;

import com.shop.model.CarDTO;
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
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class CarDTOMapperTest {

    @Autowired
    CarDTOMapper carDTOMapper;

    @Test
    public void findAll() throws Exception{
        List<CarDTO>list=carDTOMapper.findAll();
        for (CarDTO carDTO:list){
            System.out.println(carDTO);
        }
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByBrand() throws Exception{
        List<CarDTO>list=carDTOMapper.findByBrand("Toyota");
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findByModel() throws Exception{
        List<CarDTO>list=carDTOMapper.findByModel("Sedan");
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByBrandAndModel() throws Exception{
        List<CarDTO>list=carDTOMapper.findByBrandAndModel("Toyta","Sedan");
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findById()throws Exception{
        CarDTO carDTO=carDTOMapper.findById(1);
        Assert.assertNotNull(carDTO);
    }



}