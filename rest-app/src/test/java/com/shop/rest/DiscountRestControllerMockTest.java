package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Discount;
import com.shop.service.DiscountService;
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
public class DiscountRestControllerMockTest {

    private static final Logger LOGGER= LogManager.getLogger();
    @Resource
    private DiscountRestController discountController;

    private MockMvc mockMvc;

    @Autowired
    private DiscountService discountService;

    private static final Discount DISCOUNT=new Discount(3,20);

    @Before
    public void setUp() throws Exception{

        mockMvc=standaloneSetup(discountController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();

    }

    @After
    public void tearDown() throws Exception {
        verify(discountService);
        reset(discountService);
    }



    @Test
    public void findAllDiscount() throws Exception {
        LOGGER.debug("DiscountRestControllerMockTest:findAllDiscount");
        expect(discountService.findAll()).andReturn(Arrays.<Discount>asList(DISCOUNT));
        replay(discountService);

        mockMvc.perform(
                get("/discounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findDiscountByValue() throws Exception {
        LOGGER.debug("DiscountRestControllerMockTest:findDiscountByValue");
        expect(discountService.findByValue(DISCOUNT.getValueDiscount())).andReturn(DISCOUNT);
        replay(discountService);

        mockMvc.perform(
                get("/discount/value/20")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findDiscountById() throws Exception {
        LOGGER.debug("DiscountRestControllerMockTest:findDiscountById");
        expect(discountService.findById(DISCOUNT.getId())).andReturn(DISCOUNT);
        replay(discountService);

        mockMvc.perform(
                get("/discount/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void addDiscount() throws Exception {
        LOGGER.debug("DiscountRestControllerMockTest:addDiscount");
        expect(discountService.insert(anyObject(Discount.class))).andReturn(3);
        replay(discountService);

        String discount=new ObjectMapper().writeValueAsString(new Discount(30));

        mockMvc.perform(
                post("/discount")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(discount))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateDiscount() throws Exception {
        LOGGER.debug("DiscountRestControllerMockTest:updateDiscount");
        expect(discountService.update(anyObject(Discount.class))).andReturn(3);
        replay(discountService);

        String discount=new ObjectMapper().writeValueAsString(DISCOUNT);

        mockMvc.perform(
                put("/discount")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(discount))
                .andDo(print()).andExpect(status().isAccepted());

    }

}