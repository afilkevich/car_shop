package com.shop.dao;

import com.shop.model.ShoppingCartDTO;
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
 * Created by master on 5.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao-test-mybatis-spring.xml"})
@Transactional
public class ShoppingCartDTOMapperTest {
    private static final Logger LOGGER= LogManager.getLogger();
    private static final Integer ID=1;

    @Autowired
    ShoppingCartDTOMapper shoppingCartDTOMapper;

    @Test
    public void findAll() throws Exception {
        List<ShoppingCartDTO> list=shoppingCartDTOMapper.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findById() throws Exception{
        ShoppingCartDTO cartDTO=shoppingCartDTOMapper.findById(ID);
       Assert.assertNotNull(cartDTO);
    }

}