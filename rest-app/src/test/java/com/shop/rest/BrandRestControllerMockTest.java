package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
           private static final Logger LOGGER= LogManager.getLogger();
    @Resource
    private BrandRestController brandController;

    private MockMvc mockMvc;

    @Autowired
    private BrandService brandService;

     private static final Brand BRAND=new Brand(3,"BMW");

    @Before
    public void setUp() throws Exception{

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
        LOGGER.debug("BrandRestControllerMockTest:findAllBrand");
        expect(brandService.findAll()).andReturn(Arrays.<Brand>asList(BRAND));
        replay(brandService);

        mockMvc.perform(
                get("/brands")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void findBrandByName() throws Exception {
        LOGGER.debug("BrandRestControllerMockTest:findBrandByName");
        expect(brandService.findByName(BRAND.getName())).andReturn(BRAND);
        replay(brandService);

        mockMvc.perform(
                get("/brand/name/BMW")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findBrandById() throws Exception {
        LOGGER.debug("BrandRestControllerMockTest:findBrandById");
        expect(brandService.findById(BRAND.getId())).andReturn(BRAND);
        replay(brandService);

        mockMvc.perform(
                get("/brand/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addBrand() throws Exception {
        LOGGER.debug("BrandRestControllerMockTest:addBrand");
        expect(brandService.insert(anyObject(Brand.class))).andReturn(3);
        replay(brandService);

        String brand=new ObjectMapper().writeValueAsString(new Brand("op"));

        mockMvc.perform(
                post("/brand")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(brand))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateBrand() throws Exception {
        LOGGER.debug("BrandRestControllerMockTest:addBrand");
        expect(brandService.update(anyObject(Brand.class))).andReturn(3);
        replay(brandService);

        String brand=new ObjectMapper().writeValueAsString(new Brand(6,"op"));

        mockMvc.perform(
                put("/brand")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(brand))
                .andDo(print()).andExpect(status().isAccepted());

    }

}