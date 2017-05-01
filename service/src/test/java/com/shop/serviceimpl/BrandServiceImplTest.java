package com.shop.serviceimpl;

import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by master on 1.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
public class BrandServiceImplTest {


    private static final Logger LOGGER= LogManager.getLogger();
    private static final String NAME="Audi";
    private static final Integer ID=1;
    @Autowired
    BrandService brandService;

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("BrandServiceImpl test: findAll()");
        List<Brand> list=brandService.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByName() throws Exception{
        LOGGER.debug("BrandServiceImpl test: findByName()");
        Brand brand=brandService.findByName(NAME);
        Assert.assertNotNull(brand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByWrongName() throws Exception{
        Brand brand=brandService.findByName("ad");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNameNull() throws Exception {
        LOGGER.debug("BrandServiceImpl test: findByNameNull");
        Brand brand=brandService.findByName(null);
        Assert.assertNotNull(brand);
    }

    @Test
    public void findById() throws Exception {
        LOGGER.debug("BrandServiceImpl test: findById()");
        Brand brand=brandService.findById(ID);
        Assert.assertNotNull(brand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findWrongId()throws Exception{
        Brand brand=brandService.findById(67);

    }

    @Test(expected = IllegalArgumentException.class)
    public void findByNullID() throws Exception{
        LOGGER.debug("BrandServiceImpl test: findByNullId");
        Brand brand=brandService.findById(null);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}