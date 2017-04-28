package com.shop.dao;

import com.shop.model.Discount;
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
 * Created by master on 28.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis-spring-test.xml"})
@Transactional
public class DiscountMapperTest {

    @Autowired
    DiscountMapper discountMapper;
    private static final Integer VALUE=15;

    private  static final Integer VALUE_UP=12;
    private static final Discount DISCOUNT_Up=new Discount(25);

    @Test
    public void findAll() throws Exception {
        List<Discount> list=discountMapper.findAll();
        Assert.assertTrue(list.size()>0);
        for(Discount d:list){
            System.out.println(d);
        }

    }

    @Test
    public void findByValue() throws Exception {
        Discount discount=discountMapper.findByValue(VALUE);
        Assert.assertNotNull(discount);
        System.out.println(discount);
    }

    @Test
    public void insert() throws Exception {
        discountMapper.insert(DISCOUNT_Up);
        Discount discount=discountMapper.findByValue(DISCOUNT_Up.getValueDiscount());
       Assert.assertEquals(DISCOUNT_Up.getValueDiscount(),discount.getValueDiscount());

    }

    @Test
    public void update() throws Exception {
        Discount discount=discountMapper.findByValue(VALUE);
        discount.setValueDiscount(VALUE_UP);
        discountMapper.update(discount);
        Assert.assertNotNull(discountMapper.findByValue(VALUE_UP));

    }

}