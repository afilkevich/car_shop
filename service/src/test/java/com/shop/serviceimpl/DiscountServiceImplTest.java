package com.shop.serviceimpl;

import com.shop.model.Discount;
import com.shop.service.ConfigService;
import com.shop.service.DiscountService;
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
public class DiscountServiceImplTest {
    private static final Logger LOGGER= LogManager.getLogger();
    private static final Integer ID=1;
    private static final Integer WRONG_ID=6;
    private static final Integer VALUE=15;
    private static final Integer WRONG_VALUE=10;
    private static final Discount DISCOUNT=new Discount(18);
    private static final Discount UP_DISCOUNT=new Discount(2,12);
    private static final Discount WRONG_DISCOUNT=new Discount(3,12);

    @Autowired
    DiscountService discountService;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("DiscountServiceImpl test: findAll");
        List<Discount> list=discountService.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByValue() throws Exception {
        LOGGER.debug("DiscountServiceImpl test: findByValue");
        Discount discount=discountService.findByValue(VALUE);
        Assert.assertNotNull(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullValue() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: findByNullValue");
        Discount discount=discountService.findByValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongValue() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: findByWrongValue");
        Discount discount=discountService.findByValue(WRONG_VALUE);
    }

    @Test
    public void findById() throws Exception {
      LOGGER.debug("DiscountserviceImpl test: findById");
        Discount discount=discountService.findById(ID);
        Assert.assertNotNull(discount);
        Assert.assertEquals(ID,discount.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullId() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: findByNullId");
        Discount discount=discountService.findById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findWrongId() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: findWrongId");
        Discount discount=discountService.findById(WRONG_ID);
    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("DiscountServiceImpl test:insert");
        discountService.insert(DISCOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull()throws Exception{
        LOGGER.debug("DiscountServiceImpl test: insertNull");
        discountService.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertWrongValue() throws Exception{
        LOGGER.debug("DiscountServiceImpl test:insertWrongValue");
        discountService.insert(WRONG_DISCOUNT);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("DiscountServiceImpl test:update");
        discountService.update(UP_DISCOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNull() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: updateNull");
        discountService.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongDiscount() throws Exception{
        LOGGER.debug("DiscountServiceImpl test: updateWrongDiscount");
        discountService.update(WRONG_DISCOUNT);
    }

}