package com.shop.serviceimpl;

import com.shop.model.Car;
import com.shop.model.CarDTO;
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
    private static final String BRAND="Toyota";
    private static final String WRONG_BRAND="MErs";
    private static final String MODEL="Sedan";
    private static final String WRONG_MODEL="gd";
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
        List<CarDTO> list=carService.findAll();
        for(CarDTO car:list){
            System.out.println(car);
        }
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findByIdBrand() throws Exception {
        LOGGER.debug("CarServiceImpl test: findByIdBrand");
        List<CarDTO> list=carService.findByBrand(BRAND);
        Assert.assertTrue(list.size()>0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullBrand() throws Exception{
        LOGGER.debug("CarServiceImpl test: findNullBrand");
        List<CarDTO> list=carService.findByBrand(null);
    }

    @Test
    public void findByWrongBrand() throws Exception{
        LOGGER.debug("CarServiceImpl test:findByWrongBrand");
        List<CarDTO> list=carService.findByBrand(WRONG_BRAND);
        Assert.assertTrue(list.size()==0);
    }

    @Test
    public void findByModel() throws Exception {
        LOGGER.debug("CarServiceImpl test: findByModel");
        List<CarDTO> list=carService.findByModel(MODEL);
        Assert.assertTrue(list.size()>0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullModel() throws Exception{
        LOGGER.debug("CarServiceImpl test:findNullModel");
        List<CarDTO> list=carService.findByModel(null);
    }

    @Test
    public void findByWrongModel() throws Exception{
        LOGGER.debug("CarServiceImpl test:findByWrongIdModel");
        List<CarDTO>list=carService.findByModel(WRONG_MODEL);
        Assert.assertTrue(list.size()==0);
    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("CarServiceImpl test:findById");
        CarDTO car=carService.findById(ID);
        Assert.assertEquals(ID,car.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findNullId() throws Exception{
        LOGGER.debug("CarServiceIml test:findNullId");
        CarDTO car=carService.findById(null);
    }

    @Test
    public void findWrongId() throws Exception{
        LOGGER.debug("CarServiceImpl test: findWrongId");
        CarDTO car=carService.findById(WRONG_ID);
        Assert.assertNull(car);
    }

    @Test
    public void findByBrandAndModel() throws Exception{
        LOGGER.debug("CarServiceImpl test: findByBrandAndModel");
        List<CarDTO>list=carService.findByBrandAndModel(BRAND,MODEL);
        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void findByNullBtrandAndModel() throws Exception{
        LOGGER.debug("CarServiceImpl test: findByNullBrandAndModel");
        List<CarDTO>list=carService.findByBrandAndModel(null,MODEL);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByBrandAndNullModel() throws Exception{
        LOGGER.debug("CarServiceImpl test: findByBrandAndNullModel");
        List<CarDTO>list=carService.findByBrandAndModel(BRAND,null);
        Assert.assertTrue(list.size()>0);
    }

    /*@Test
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
*/
}