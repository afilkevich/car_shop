package com.shop.dao;

import com.shop.model.ShoppingCart;
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
 * Created by master on 29.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class ShoppingCartMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();

    private static final ShoppingCart CART= new ShoppingCart(2,2,6,82000);
    private static final Integer ID=1;
    private static final Integer ID_UP=2;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("ShoppingCartMapperTest:findAll()");
        List<ShoppingCart> list=shoppingCartMapper.findAll();
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("ShoppingCartMapperTest:findById()");
        ShoppingCart cart=shoppingCartMapper.findById(ID);
        Assert.assertNotNull(cart);

    }

    @Test
    public void insert() throws Exception {
        LOGGER.debug("ShoppingCartMapperTest:insert()");
        shoppingCartMapper.insert(CART);
        ShoppingCart cart=shoppingCartMapper.findById(ID_UP);
        Assert.assertNotNull(cart);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("ShoppingCartMApperTest:update()");
        ShoppingCart cart=shoppingCartMapper.findById(ID);
        cart.setAmountCar(10);
        shoppingCartMapper.update(cart);
        Assert.assertTrue(shoppingCartMapper.findById(ID).getAmountCar()==10);

    }

}