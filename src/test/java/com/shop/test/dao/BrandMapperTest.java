package com.shop.test.dao;

import com.shop.dao.BrandDAO;
import com.shop.model.Brand;
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
 * Created by master on 27.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-test.xml"})
@Transactional
public class BrandMapperTest {
    private static  final Logger LOGGER= LogManager.getLogger();

    @Autowired
    BrandDAO brandDAO;

    private static final String name="Toyota";

    private  static final String nameUP="Audi1";
    private static final Brand brandUp=new Brand("BMW");

    @Test
    public void findAll() throws Exception {
        LOGGER.debug("BrandMapperTest:findall()");
        List<Brand> list=brandDAO.findAll();
        Assert.assertTrue(list.size()>0);
        for (Brand b: list){
            System.out.println(b);
        }

    }
//
//    @Test
//    public void update()throws Exception{
//        LOGGER.debug("BrandMapperTest:update()");
//        Brand brand=brandMapper.findByName("Audi");
//        brand.setName(nameUP);
//        brandMapper.update(brand);
//        Brand nbrand=brandMapper.findByName(nameUP);
//        Assert.assertNotNull(nbrand);
//    }
//
//    @Test
//    public void insert() throws Exception{
//        LOGGER.debug("BrandMapperTest:insert()");
//        brandMapper.insert(brandUp);
//        List<Brand> list=brandMapper.findAll();
//        Assert.assertTrue(list.size()==3);
//    }
//
//    @Test
//    public void findByName() throws Exception{
//        LOGGER.debug("BrandMapperTest:findByName()");
//        Brand brand=brandMapper.findByName(name);
//        Assert.assertEquals(name,brand.getName());
//
//    }
//
//    @Test
//    public void findById() throws Exception{
//        LOGGER.debug("brandMapperTest:findByID");
//        Brand brand=brandMapper.findById(1);
//        Assert.assertNotNull(brand);
//    }
//


}