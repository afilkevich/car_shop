package com.shop.serviceimpl;

import com.shop.model.ShoppingCart;
import com.shop.service.ShoppingCartService;
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
 * Created by master on 3.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
@Transactional
public class ShoppingCartServiceImplTest {

    private static final Logger LOGGER= LogManager.getLogger();

    private static final ShoppingCart CART=new ShoppingCart(1,7);
    private static final ShoppingCart WRONG_CART=new ShoppingCart(2,3,4,8,89);
    private static final Integer DISCOUNT_ID=2;
    private static final Integer PRICE=29750;
    private static final Integer AMOUNT=10;
    private static final Integer ID=1;
    private static final Integer Wrong_ID=8;


    @Autowired
    ShoppingCartService shoppingCartService;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("ShoppingCartServiceImpl test: findAll");
        List<ShoppingCart> list=shoppingCartService.findAll();

        Assert.assertTrue(list.size()>0);

   }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("ShoppingCartServiceImpl test: findById");
        ShoppingCart shoppingCart=shoppingCartService.findById(ID);
        Assert.assertEquals(ID,shoppingCart.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullId() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test:findByNullId");
        ShoppingCart shoppingCart=shoppingCartService.findById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongId() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test: findByWrongId");
        ShoppingCart shoppingCart=shoppingCartService.findById(Wrong_ID);
    }


    @Test
    public void insert() throws Exception {
        LOGGER.debug("ShoppingCartServiceImpl test: insert");
        shoppingCartService.insert(CART);
        ShoppingCart cart=shoppingCartService.findById(2);
        Assert.assertNotNull(cart);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test:insertNull");
        shoppingCartService.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertWrongCart() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test: insertWrongCart");
        shoppingCartService.insert(WRONG_CART);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("ShoppingCartServiceImpl test:update");
        ShoppingCart cart=shoppingCartService.findById(ID);
        cart.setAmountCar(AMOUNT);
        shoppingCartService.update(cart);
        cart=shoppingCartService.findById(ID);
        Assert.assertEquals(AMOUNT,cart.getAmountCar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNull() throws Exception{
        LOGGER.debug("ShoppingCartServiceIml test:updateNull");
        shoppingCartService.update(null);
    }

    @Test
    public void delete() throws Exception {
        LOGGER.debug("ShoppingCartImpl test:delete");
        shoppingCartService.delete(1);
        List<ShoppingCart> list=shoppingCartService.findAll();
        Assert.assertTrue(list.size()==0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void deleteNull() throws Exception{
        LOGGER.debug("ShoppingCartImpl test: deleteNull");
        shoppingCartService.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteWrongId() throws Exception{
        LOGGER.debug("ShoppingCartImpl test: deleteWrongId");
        shoppingCartService.delete(Wrong_ID);

    }

    @Test
    public void calculatePrice() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test:calculatePrice");
        shoppingCartService.calculatePrice(CART);
        Assert.assertEquals(DISCOUNT_ID,CART.getIdDiscount());
        Assert.assertEquals(PRICE,CART.getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatePriceNull() throws Exception{
        LOGGER.debug("ShoppingCartServiceImpl test: calculatePriceNull");
        shoppingCartService.calculatePrice(null);
    }


}