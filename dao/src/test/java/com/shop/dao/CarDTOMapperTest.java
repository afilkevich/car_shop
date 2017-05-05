package com.shop.dao;

import com.shop.model.CarDTO;
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
    }

}