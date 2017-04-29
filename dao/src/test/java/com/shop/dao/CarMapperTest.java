package com.shop.dao;

import com.shop.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by master on 29.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class CarMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    CarMapper carMapper;

    private static final Integer ID_BRAND=1;
    private static final Integer ID_MODEL=2;
    private static final Integer ID=1;

    private static final Car CAR=new Car(2,2,3, LocalDate.parse("2009-02-09"),10000);

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("carMapperTest:findall()");
        List<Car> list=carMapper.findAll();
        Assert.assertTrue(list.size()>0);
            }

    @Test
    public void findByIdBrand() throws Exception {
        LOGGER.debug("carMapperTest:findByIdBrand()");
        List<Car>list=carMapper.findByIdBrand(ID_BRAND);
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public  void findByIdModel() throws Exception{
        LOGGER.debug("carMapperTest:findByIdModel()");
        List<Car> list=carMapper.findByIdModel(ID_MODEL);
        Assert.assertTrue(list.size()>0);
    }


    @Test
    public void delete() throws Exception{
        LOGGER.debug("carMapperTest:delete()");
        carMapper.delete(ID);
        List<Car> list=carMapper.findAll();
        Assert.assertTrue(list.size()==1);
    }

    @Test
    public void findById() throws Exception{
        LOGGER.debug("carMapperTest:findById()");
        Car car=carMapper.findById(ID);
        Assert.assertNotNull(car);
    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("carMapperTest:insert()");
        carMapper.insert(CAR);
        List<Car> list=carMapper.findAll();
        Assert.assertTrue(list.size()>2);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("carMapperTest:update()");
        Car car=carMapper.findById(ID);
        car.setPrice(2000);
        carMapper.update(car);
        Assert.assertTrue(carMapper.findById(ID).getPrice()==2000);
    }

}