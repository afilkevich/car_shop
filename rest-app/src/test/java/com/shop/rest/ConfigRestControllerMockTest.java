package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Config;
import com.shop.service.ConfigService;
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
public class ConfigRestControllerMockTest {
    private static final Logger LOGGER= LogManager.getLogger();
    @Resource
    private ConfigRestController configController;

    private MockMvc mockMvc;

    @Autowired
    private ConfigService configService;

    private static final Config CONFIG=new Config(3,"Stand","Desc");

    @Before
    public void setUp() throws Exception{

        mockMvc=standaloneSetup(configController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        verify(configService);
        reset(configService);
    }

    @Test
    public void findAllConfig() throws Exception {
        LOGGER.debug("ConfigRestControllerMockTest:findAllConfig");
        expect(configService.findAll()).andReturn(Arrays.<Config>asList(CONFIG));
        replay(configService);

        mockMvc.perform(
                get("/configs")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void findConfigByType() throws Exception {
        LOGGER.debug("ConfigRestControllerMockTest:findConfigByType");
        expect(configService.findByType(CONFIG.getType())).andReturn(CONFIG);
        replay(configService);

        mockMvc.perform(
                get("/config/type/Stand")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findConfigById() throws Exception {
        LOGGER.debug("ConfigRestControllerMockTest:findConfigById");
        expect(configService.findById(CONFIG.getId())).andReturn(CONFIG);
        replay(configService);

        mockMvc.perform(
                get("/config/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addConfig() throws Exception {
        LOGGER.debug("ConfigRestControllerMockTest:addConfig");
        expect(configService.insert(anyObject(Config.class))).andReturn(3);
        replay(configService);

        String config=new ObjectMapper().writeValueAsString(new Config("LUX","DESc"));

        mockMvc.perform(
                post("/config")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(config))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateConfig() throws Exception {
        LOGGER.debug("ConfigRestControllerMockTest:updateConfig");
        expect(configService.update(anyObject(Config.class))).andReturn(3);
        replay(configService);

        String config=new ObjectMapper().writeValueAsString(CONFIG);

        mockMvc.perform(
                put("/config")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(config))
                .andDo(print()).andExpect(status().isAccepted());

    }

}