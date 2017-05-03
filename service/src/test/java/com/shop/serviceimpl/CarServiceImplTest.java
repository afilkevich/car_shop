package com.shop.serviceimpl;

import com.shop.model.Car;
import com.shop.service.CarService;
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
 * Created by master on 3.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
@Transactional
public class CarServiceImplTest {

    private static final Logger LOGGER= LogManager.getLogger();
    private static final Integer ID_BRAND=1;
    private static final Integer WRONG_ID_BRAND=4;
    private static final Integer ID_MODEL=2;
    private static final Integer WRONG_ID_MODEL=8;
    private static final Integer ID=2;
    private static final Integer WRONG_ID=9;
    private static final Integer PRICE=4590;
    private static final Car CAR=new Car(2,2,3, LocalDate.parse("2001-09-08"),3200);
    private static final Car WRONG_CAR=new Car(3,2,4,null,0);



    @Autowired
    CarService carService;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("CarServiceImpl test: find all");
        List<Car> list=carService.findAll();
        for(Car car:list){
            System.out.println(car);
        }
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findByIdBrand() throws Exception {
        LOGGER.debug("CarServiceImpl test: findByIdBrand");
        List<Car> list=carService.findByIdBrand(ID_BRAND);
        Assert.assertTrue(list.size()>0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullBrand() throws Exception{
        LOGGER.debug("CarServiceImpl test: findNullBrand");
        List<Car> list=carService.findByIdBrand(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongIdBrand() throws Exception{
        LOGGER.debug("CarServiceImpl test:findByWrongIdBrand");
        List<Car> list=carService.findByIdBrand(WRONG_ID_BRAND);
    }

    @Test
    public void findByIdModel() throws Exception {
        LOGGER.debug("CarServiceImpl test: findByIdModel");
        List<Car> list=carService.findByIdModel(ID_MODEL);
        Assert.assertTrue(list.size()>0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullIdModel() throws Exception{
        LOGGER.debug("CarServiceImpl test:findNullIdModel");
        List<Car> list=carService.findByIdModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongIdModel() throws Exception{
        LOGGER.debug("CarServiceImpl test:findByWrongIdModel");
        List<Car>list=carService.findByIdModel(WRONG_ID_MODEL);
    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("CarServiceImpl test:findById");
        Car car=carService.findById(ID);
        Assert.assertEquals(ID,car.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findNullId() throws Exception{
        LOGGER.debug("CarServiceIml test:findNullId");
        Car car=carService.findById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findWrongId() throws Exception{
        LOGGER.debug("CarServiceImpl test: findWrongId");
        Car car=carService.findById(WRONG_ID);
    }

    @Test
    public void insert() throws Exception {
      LOGGER.debug("CarServiceImpl test:insert");
      carService.insert(CAR);
      List<Car> list=carService.findAll();
      Assert.assertTrue(list.size()==3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull() throws Exception{
        LOGGER.debug("CarServiceImpl test: insertNull");
        carService.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertWrongCar() throws Exception{
        LOGGER.debug("CarServiceImpl test: insertWrongCar");
        carService.insert(WRONG_CAR);
    }

    @Test
    public void update() throws Exception {
      LOGGER.debug("CarServiceImpl test: update");
      Car car=carService.findById(ID);
      car.setPrice(PRICE);
      carService.update(car);
      Assert.assertEquals(PRICE,carService.findById(ID).getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNull() throws Exception{
        LOGGER.debug("CarServiceImpl test: updateNull");
        carService.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongCar() throws Exception{
        LOGGER.debug("CarServiceImpl test: updateWrongCar");
        carService.update(WRONG_CAR);
    }

    @Test
    public void delete() throws Exception {
        LOGGER.debug("CarServiceImpl test: delete");
        carService.delete(ID);
        List<Car> list=carService.findAll();
        Assert.assertTrue(list.size()<2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteNull() throws Exception{
        LOGGER.debug("CarServiceImpl test: deleteNull");
        carService.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteWrongId() throws Exception{
        LOGGER.debug("CarServiceImpl test: deleteWrongId");
        carService.delete(WRONG_ID);

    }

}