package com.shop.dao;

import com.shop.model.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by master on 27.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis-spring-test.xml"})
public class BrandMapperTest {

    @Autowired
    BrandMapper brandMapper;

    @Test
    public void findAll() throws Exception {
        List<Brand> list=brandMapper.findAll();
        Assert.assertTrue(list.size()>0);

    }

}