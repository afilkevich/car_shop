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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * Created by master on 1.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-mybatis-spring.xml"})
@Transactional
public class BrandServiceImplTest {


    private static final Logger LOGGER= LogManager.getLogger();
    private static final String NAME="Audi";
    private static final Integer ID=1;
    private static final Brand BRAND=new Brand("BMW");

    private static final Brand UP_BRAND=new Brand(2,"Toyota Corp.");
    private static final Brand EMPTY_BRAND=new Brand();
    private static final Brand WRONG_BRAND=new Brand(78,"TO");
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
        System.out.println(brand);
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
        LOGGER.debug("BrandServiceImpl test: insert");
        brandService.insert(BRAND);
        Brand brand=brandService.findByName(BRAND.getName());
        Assert.assertNotNull(brand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull() throws Exception{
        LOGGER.debug("BrandServiceIml test:insertNull");
        brandService.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNullName() throws Exception{
        LOGGER.debug("BrandServiceIml test:insertNull");
        brandService.insert(EMPTY_BRAND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertWrongBrand() throws Exception{
        brandService.insert(WRONG_BRAND);
    }

    @Test
    public void update() throws Exception {
        LOGGER.debug("BrandServiceImpl test: update");
        brandService.update(UP_BRAND);
        Brand brand=brandService.findByName(UP_BRAND.getName());
        Assert.assertNotNull(brand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateEmptyBrand() throws Exception{
        LOGGER.debug("BrandServiceImpl test: updateEmptyBrand");
        brandService.update(EMPTY_BRAND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongBrand()throws Exception{
        LOGGER.debug("BrandServiceImpl test: updateWrongBrand");
        brandService.update(WRONG_BRAND);
    }

}