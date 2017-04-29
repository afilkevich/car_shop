package com.shop.dao;

import com.shop.model.Discount;
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
 * Created by master on 28.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class DiscountMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    DiscountMapper discountMapper;

    private static final Integer VALUE=15;
    private  static final Integer VALUE_UP=12;
    private static final Discount DISCOUNT_Up=new Discount(25);

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("DiscountMapperTest:findall()");
        List<Discount> list=discountMapper.findAll();
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findByValue() throws Exception {
        LOGGER.debug("DiscountMapperTest:findByValue()");
        Discount discount=discountMapper.findByValue(VALUE);
        Assert.assertNotNull(discount);
        System.out.println(discount);
    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("DiscountMapperTest:insert()");
        discountMapper.insert(DISCOUNT_Up);
        Discount discount=discountMapper.findByValue(DISCOUNT_Up.getValueDiscount());
       Assert.assertEquals(DISCOUNT_Up.getValueDiscount(),discount.getValueDiscount());

    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("DiscountMapperTest:update()");
        Discount discount=discountMapper.findByValue(VALUE);
        discount.setValueDiscount(VALUE_UP);
        discountMapper.update(discount);
        Assert.assertNotNull(discountMapper.findByValue(VALUE_UP));
    }

}