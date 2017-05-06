package com.shop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.ShoppingCart;
import com.shop.model.ShoppingCartDTO;
import com.shop.service.ShoppingCartService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by master on 4.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:rest-spring-mocktest.xml"})
public class ShoppingCartRestControllerMockTest {
    private static final Logger LOGGER= LogManager.getLogger();

    @Resource
    private ShoppingCartRestController cartController;

    private MockMvc mockMvc;

    @Autowired
    private ShoppingCartService cartService;

    private static final ShoppingCartDTO CART_DTO=new ShoppingCartDTO(1,1,15,20,7800);

    @Before
    public void setUp() throws Exception{

        mockMvc=standaloneSetup(cartController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        verify(cartService);
        reset(cartService);
    }
    @Test
    public void findAllShoppingCart() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findAllCart");
        expect(cartService.findAll()).andReturn(Arrays.<ShoppingCartDTO>asList(CART_DTO));
        replay(cartService);

        mockMvc.perform(
                get("/carts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

/*    @Test
    public void findShoppingCarById() throws Exception {
        LOGGER.debug("CarRestControllerMockTest:findShoppingCartById");
        expect(cartService.findById(CART.getId())).andReturn(CART);
        replay(cartService);

        mockMvc.perform(
                get("/cart/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addShoppingCart() throws Exception {
        LOGGER.debug("ShoppingCartRestControllerMockTest:addCart");
        expect(cartService.insert(anyObject(ShoppingCart.class))).andReturn(1);
        replay(cartService);

        String cart=new ObjectMapper().writeValueAsString(new ShoppingCart());

        mockMvc.perform(
                post("/cart")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cart))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void updateShoppingCart() throws Exception {
        LOGGER.debug("ShoppingCartRestControllerMockTest:updateCart");
        expect(cartService.update(anyObject(ShoppingCart.class))).andReturn(1);
        replay(cartService);

        String cart=new ObjectMapper().writeValueAsString(new ShoppingCart());

        mockMvc.perform(
                put("/cart")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cart))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    public void deleteShoppingCart() throws Exception {
        LOGGER.debug("ShoppingCartRestControllerMockTest:deleteCart");
        expect(cartService.delete(CART.getId())).andReturn(1);
        replay(cartService);

        mockMvc.perform(
                delete("/cart/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
*/
}