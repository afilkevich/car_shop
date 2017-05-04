package com.shop.rest;

import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by master on 4.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:rest-spring-mocktest.xml"})

public class BrandRestControllerMockTest {

    @Resource
    private BrandRestController brandController;
    private MockMvc mockMvc;
    @Autowired
    private BrandService brandService;
     private static final Brand brand=new Brand("BMW");

    @Before
    public void setUp() throws Exception {
        mockMvc=standaloneSetup(brandController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

    }

    @After
    public void tearDown() throws Exception {
        verify(brandService);
        reset(brandService);

    }

    @Test
    public void findAllBrand() throws Exception {
        expect(brandService.findAll()).andReturn(Arrays.<Brand>asList(brand));
        replay(brandService);

        mockMvc.perform(
                get("/brands")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void findBrandByName() throws Exception {

    }

    @Test
    public void findBrandById() throws Exception {

    }

    @Test
    public void addBrand() throws Exception {

    }

    @Test
    public void updateBrand() throws Exception {

    }

}