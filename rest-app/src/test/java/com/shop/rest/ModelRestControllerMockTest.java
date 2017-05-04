package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Model;
import com.shop.service.ModelService;
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
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by master on 4.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:rest-spring-mocktest.xml"})
public class ModelRestControllerMockTest {
    private static final Logger LOGGER= LogManager.getLogger();
    @Resource
    private ModelRestController modelController;

    private MockMvc mockMvc;

    @Autowired
    private ModelService modelService;

    private static final Model MODEL=new Model(3,"Jeep");

    @Before
    public void setUp() throws Exception{

        mockMvc=standaloneSetup(modelController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

    }

    @After
    public void tearDown() throws Exception {
        verify(modelService);
        reset(modelService);

    }


    @Test
    public void findAllModel() throws Exception {
        LOGGER.debug("ModelRestControllerMockTest:findAllModel");
        expect(modelService.findAll()).andReturn(Arrays.<Model>asList(MODEL));
        replay(modelService);

        mockMvc.perform(
                get("/models")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void findModelByName() throws Exception {
        LOGGER.debug("ModelRestControllerMockTest:findModelByName");
        expect(modelService.findByName(MODEL.getName())).andReturn(MODEL);
        replay(modelService);

        mockMvc.perform(
                get("/model/name/Jeep")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findModelById() throws Exception {
        LOGGER.debug("ModelRestControllerMockTest:findModelById");
        expect(modelService.findById(MODEL.getId())).andReturn(MODEL);
        replay(modelService);

        mockMvc.perform(
                get("/model/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addModel() throws Exception {
        LOGGER.debug("ModelRestControllerMockTest:addModel");
        expect(modelService.insert(anyObject(Model.class))).andReturn(3);
        replay(modelService);

        String model=new ObjectMapper().writeValueAsString(new Model("mod"));

        mockMvc.perform(
                post("/model")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(model))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateModel() throws Exception {
        LOGGER.debug("ModelRestControllerMockTest:updateModel");
        expect(modelService.update(anyObject(Model.class))).andReturn(3);
        replay(modelService);

        String model=new ObjectMapper().writeValueAsString(new Model(6,"mode"));

        mockMvc.perform(
                put("/model")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(model))
                .andDo(print()).andExpect(status().isAccepted());
    }

}