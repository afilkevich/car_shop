package com.shop.dao;

import com.shop.model.Brand;
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
 * Created by master on 27.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis-spring-test.xml"})
@Transactional
public class BrandMapperTest {

    @Autowired
    BrandMapper brandMapper;

    private static final String name="Toyota";

    private  static final String nameUP="Audi1";
    private static final Brand brandUp=new Brand("BMW");

    @Test
    public void findAll() throws Exception {
        List<Brand> list=brandMapper.findAll();

        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void update()throws Exception{
        Brand brand=brandMapper.findByName("Audi");
        brand.setName(nameUP);
        brandMapper.update(brand);
        Brand nbrand=brandMapper.findByName(nameUP);
        Assert.assertNotNull(nbrand);
    }

    @Test
    public void insert() throws Exception{
        brandMapper.insert(brandUp);
        List<Brand> list=brandMapper.findAll();
        Assert.assertTrue(list.size()==3);
    }





    @Test
    public void findByName() throws Exception{
        Brand brand=brandMapper.findByName(name);
        Assert.assertEquals(name,brand.getName());

    }


}